package org.wildstang.year2021.subsystems;

import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.kauailabs.navx.frc.AHRS;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;
import org.wildstang.year2021.subsystems.DriveConstants;
import org.wildstang.year2021.subsystems.DriveSignal;
import org.wildstang.year2021.subsystems.WSSwerveHelper;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SlewRateLimiter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveDrive implements Subsystem {

    private final SlewRateLimiter xSpeedLimiter = new SlewRateLimiter(DriveConstants.SLEW_RATE_LIMIT);
    private final SlewRateLimiter ySpeedLimiter = new SlewRateLimiter(DriveConstants.SLEW_RATE_LIMIT);
    private final SlewRateLimiter rotSpeedLimiter = new SlewRateLimiter(DriveConstants.SLEW_RATE_LIMIT);

    private AnalogInput leftStickX;//translation joystick x
    private AnalogInput leftStickY;//translation joystick y
    private AnalogInput rightStickX;//rot joystick
    private AnalogInput rightTrigger;//thrust
    private DigitalInput rightBumper;//defense mode, aka cross
    private DigitalInput select;//gyro reset
    private DigitalInput faceUp;
    private DigitalInput faceRight;
    private DigitalInput faceLeft;
    private DigitalInput faceDown;

    private double xSpeed;
    private double ySpeed;
    private double rotSpeed;
    private boolean isFieldOriented;
    private double thrustValue;
    private boolean rotLocked;
    private double rotTarget;
    private double pathPos;
    private double pathVel;
    private double pathHeading;
    private double pathTarget;
    private double autoTravelled;
    private double autoTempX;
    private double autoTempY;

    private final AHRS gyro = new AHRS(I2C.Port.kOnboard);
    private SwerveModule[] modules;
    private DriveSignal driveSignal;
    private WSSwerveHelper swerveHelper = new WSSwerveHelper();

    public enum driveType {TELEOP, AUTO, CROSS};
    public driveType driveState;

    @Override
    public void inputUpdate(Input source) {
        if (driveState != driveType.AUTO && rightBumper.getValue()){
            driveState = driveType.CROSS;
        } else if (driveState != driveType.AUTO){
            driveState = driveType.TELEOP;
        }
        xSpeed = -xSpeedLimiter.calculate(leftStickY.getValue());
        if (Math.abs(leftStickY.getValue()) < DriveConstants.DEADBAND) xSpeed = 0;
        ySpeed = ySpeedLimiter.calculate(leftStickX.getValue());
        if (Math.abs(leftStickX.getValue()) < DriveConstants.DEADBAND) ySpeed = 0;
        
        if (source == select && select.getValue()) gyro.reset();
        thrustValue = 1 - DriveConstants.DRIVE_THRUST + DriveConstants.DRIVE_THRUST * Math.abs(rightTrigger.getValue());

        if (faceUp.getValue()){
            rotTarget = 0.0;
            rotLocked = true;
        } else if (faceLeft.getValue()){
            rotTarget = 270.0;
            rotLocked = true;
        } else if (faceRight.getValue()){
            rotTarget = 90.0;
            rotLocked = true;
        } else if (faceDown.getValue()){
            rotTarget = 180.0;
            rotLocked = true;
        }
        rotSpeed = -rotSpeedLimiter.calculate(rightStickX.getValue());
        if (Math.abs(rightStickX.getValue()) < DriveConstants.DEADBAND) rotSpeed = 0;
        if (rotSpeed != 0) rotLocked = false;
    }
 
    @Override
    public void init() {
        // TODO Auto-generated method stub
        initInputs();
        initOutputs();
        resetState();
        gyro.reset();
    }

    public void initInputs(){
        leftStickX = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_X);
        leftStickX.addInputListener(this);
        leftStickY = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y);
        leftStickY.addInputListener(this);
        rightStickX = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_X);
        rightStickX.addInputListener(this);
        rightTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_TRIGGER);
        rightTrigger.addInputListener(this);
        rightBumper = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_SHOULDER);
        rightBumper.addInputListener(this);
        select = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_SELECT);
        select.addInputListener(this);
        faceUp = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_UP);
        faceUp.addInputListener(this);
        faceLeft = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_LEFT);
        faceLeft.addInputListener(this);
        faceRight = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_RIGHT);
        faceRight.addInputListener(this);
        faceDown = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_DOWN);
        faceDown.addInputListener(this);
    }

    public void initOutputs(){
        modules = new SwerveModule[]{
            new SwerveModule(new CANSparkMax(CANConstants.DRIVE1, MotorType.kBrushless), 
                new CANSparkMax(CANConstants.ANGLE1, MotorType.kBrushless), new CANCoder(CANConstants.ENC1), DriveConstants.FRONT_LEFT_OFFSET),
            new SwerveModule(new CANSparkMax(CANConstants.DRIVE2, MotorType.kBrushless), 
                new CANSparkMax(CANConstants.ANGLE2, MotorType.kBrushless), new CANCoder(CANConstants.ENC2), DriveConstants.FRONT_RIGHT_OFFSET),
            new SwerveModule(new CANSparkMax(CANConstants.DRIVE3, MotorType.kBrushless), 
                new CANSparkMax(CANConstants.ANGLE3, MotorType.kBrushless), new CANCoder(CANConstants.ENC3), DriveConstants.REAR_LEFT_OFFSET),
            new SwerveModule(new CANSparkMax(CANConstants.DRIVE4, MotorType.kBrushless), 
                new CANSparkMax(CANConstants.ANGLE4, MotorType.kBrushless), new CANCoder(CANConstants.ENC4), DriveConstants.REAR_RIGHT_OFFSET)
        };
        driveSignal = new DriveSignal(new double[]{0.0, 0.0, 0.0, 0.0}, new double[]{0.0, 0.0, 0.0, 0.0});
    }
    
    @Override
    public void selfTest() {
        // TODO Auto-generated method stub
    }

    @Override
    public void update() {
        switch (driveState) {
        case CROSS:
            if (xSpeed == 0 && ySpeed == 0){
                driveSignal = swerveHelper.setCross();
                drive();
            } else {
                driveSignal = swerveHelper.setCrab(xSpeed, ySpeed, gyro.getAngle());
                drive();
            }
        case TELEOP:
            if (rotLocked){
                rotSpeed = swerveHelper.getRotControl(rotTarget, gyro.getAngle());
            }
            driveSignal = swerveHelper.setDrive(xSpeed, ySpeed, rotSpeed, gyro.getAngle());
            drive();
        case AUTO:

            rotSpeed = swerveHelper.getRotControl(pathTarget, gyro.getAngle());
            if (Math.abs(rotSpeed) > 0.2) rotSpeed /= (Math.abs(rotSpeed * 0.2));
            updateAutoDistance();
            driveSignal = swerveHelper.setAuto(swerveHelper.getAutoPower(pathPos, pathVel, autoTravelled), pathHeading, rotSpeed, gyro.getAngle());
            drive();

        
        }
        SmartDashboard.putNumber("Gyro Reading", gyro.getRotation2d().getDegrees());
        SmartDashboard.putBoolean("Is field oriented", isFieldOriented);
        SmartDashboard.putNumber("Thrust value", thrustValue);
    }

    @Override
    public void resetState() {
        xSpeed = 0;
        ySpeed = 0;
        rotSpeed = 0;
        isFieldOriented = true;//should be true
        //gyro.reset();
        setToTeleop();
        rotLocked = false;
        rotTarget = 0.0;
        pathPos = 0.0;
        pathVel = 0.0;
        pathHeading = 0.0;
        pathTarget = 0.0;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Swerve Drive";
    }
    public void resetDriveEncoders(){
        for (int i = 0; i < modules.length; i++){
            modules[i].resetDriveEncoders();
        }
    }
    public void setToTeleop(){
        driveState = driveType.TELEOP;
        for (int i = 0; i < modules.length; i++){
            modules[i].setDriveBrake(false);
        }
    }
    public void setToAuto(){
        driveState = driveType.AUTO;
    }
    public void stopMoving(){
        driveSignal = swerveHelper.setCrab(0.0, 0.0, gyro.getAngle());
        drive();
    }
    private void drive(){
        for (int i = 0; i < modules.length; i++){
            modules[i].run(driveSignal.getSpeed(i), driveSignal.getSpeed(i));
            modules[i].displayNumbers(DriveConstants.POD_NAMES[i]);
        }
    }
    public void setAutoValues(double position, double velocity, double heading){
        pathPos = position;
        pathVel = velocity;
        pathHeading = heading;
        autoTravelled = 0;
    }
    public void setAutoHeading(double headingTarget){
        pathTarget = headingTarget;
    }
    private void updateAutoDistance(){
        for (int i = 0; i < modules.length; i++){
            autoTempX += modules[i].getPosition() * Math.cos(Math.toRadians(modules[i].getAngle()));
            autoTempY += modules[i].getPosition() * Math.sin(Math.toRadians(modules[i].getAngle()));
        }
        autoTravelled += Math.hypot(autoTempX/modules.length, autoTempY/modules.length);
    }
    
}
