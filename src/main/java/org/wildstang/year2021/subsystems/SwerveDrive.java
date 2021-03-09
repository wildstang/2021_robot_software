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

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SlewRateLimiter;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Units;

public class SwerveDrive implements Subsystem {

    public static final double maxSpeed = Units.feetToMeters(14.4);//14.4 ft/s max speed
    private static final double maxAngularSpeed = 21.25; // 1/2PI * value rotations per second
    private final String[] names = new String[]{"Front Left", "Front Right", "Back Left", "Back Right"};
    private final double WIDTH = 11.5;//inches
    private final double LENGTH = 11.5;//inches
    private final double offset1 = -280.98;//pod 1 offset in deg
    private final double offset2 = -313.59;
    private final double offset3 = -199.95;
    private final double offset4 = -52.03;
    private final double deadband = 0.1;

    private final SlewRateLimiter xSpeedLimiter = new SlewRateLimiter(3);
    private final SlewRateLimiter ySpeedLimiter = new SlewRateLimiter(3);
    private final SlewRateLimiter rotSpeedLimiter = new SlewRateLimiter(3);

    private AnalogInput leftStickX;
    private AnalogInput leftStickY;
    private AnalogInput rightStickX;
    private DigitalInput rightBumper;

    private double xSpeed;
    private double ySpeed;
    private double rotSpeed;
    private boolean isFieldOriented;

    private final AHRS gyro = new AHRS(I2C.Port.kOnboard);
    private SwerveModule[] modules;

    private SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
        new Translation2d(Units.inchesToMeters(-LENGTH/2), Units.inchesToMeters(-WIDTH/2)),
        new Translation2d(Units.inchesToMeters(-LENGTH/2), Units.inchesToMeters(WIDTH/2)),
        new Translation2d(Units.inchesToMeters(LENGTH/2), Units.inchesToMeters(-WIDTH/2)),
        new Translation2d(Units.inchesToMeters(LENGTH/2), Units.inchesToMeters(WIDTH/2))
    );

    @Override
    public void inputUpdate(Input source) {
        // TODO Auto-generated method stub
        xSpeed = -xSpeedLimiter.calculate(leftStickY.getValue())*maxSpeed;
        if (Math.abs(leftStickY.getValue()) < deadband) xSpeed = 0;
        ySpeed = ySpeedLimiter.calculate(leftStickX.getValue())*maxSpeed;
        if (Math.abs(leftStickX.getValue()) < deadband) ySpeed = 0;
        rotSpeed = -rotSpeedLimiter.calculate(rightStickX.getValue())*maxAngularSpeed;
        SmartDashboard.putNumber("Rotation joystick", rightStickX.getValue());
        SmartDashboard.putNumber("Rotation", rotSpeed);
        if (Math.abs(rightStickX.getValue()) < deadband) rotSpeed = 0;
        if (source == rightBumper && rightBumper.getValue()) isFieldOriented = !isFieldOriented;
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        initInputs();
        initOutputs();
        resetState();

    }

    public void initInputs(){
        leftStickX = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_X);
        leftStickX.addInputListener(this);
        leftStickY = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y);
        leftStickY.addInputListener(this);
        rightStickX = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_X);
        rightStickX.addInputListener(this);
        rightBumper = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_SHOULDER_RIGHT);
        rightBumper.addInputListener(this);
    }

    public void initOutputs(){
        modules = new SwerveModule[]{
            new SwerveModule(new CANSparkMax(CANConstants.DRIVE1, MotorType.kBrushless), 
                new CANSparkMax(CANConstants.ANGLE1, MotorType.kBrushless), new CANCoder(CANConstants.ENC1), Rotation2d.fromDegrees(offset1)),
            new SwerveModule(new CANSparkMax(CANConstants.DRIVE2, MotorType.kBrushless), 
                new CANSparkMax(CANConstants.ANGLE2, MotorType.kBrushless), new CANCoder(CANConstants.ENC2), Rotation2d.fromDegrees(offset2)),
            new SwerveModule(new CANSparkMax(CANConstants.DRIVE3, MotorType.kBrushless), 
                new CANSparkMax(CANConstants.ANGLE3, MotorType.kBrushless), new CANCoder(CANConstants.ENC3), Rotation2d.fromDegrees(offset3)),
            new SwerveModule(new CANSparkMax(CANConstants.DRIVE4, MotorType.kBrushless), 
                new CANSparkMax(CANConstants.ANGLE4, MotorType.kBrushless), new CANCoder(CANConstants.ENC4), Rotation2d.fromDegrees(offset4))
        };
    }

    @Override
    public void selfTest() {
        // TODO Auto-generated method stub
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        SwerveModuleState[] states = kinematics.toSwerveModuleStates(
            isFieldOriented ? ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rotSpeed, gyro.getRotation2d()) : new ChassisSpeeds(xSpeed, ySpeed, rotSpeed));
        SwerveDriveKinematics.normalizeWheelSpeeds(states, maxSpeed);
        for (int i = 0; i < states.length; i++){
            SwerveModule module = modules[i];
            SwerveModuleState state = states[i];
            module.setDesiredState(state);
            module.displayNumbers(names[i]);
        }
        SmartDashboard.putNumber("Gyro Reading", gyro.getRotation2d().getDegrees());
        SmartDashboard.putBoolean("Is field oriented", isFieldOriented);
    }

    @Override
    public void resetState() {
        // TODO Auto-generated method stub
        xSpeed = 0;
        ySpeed = 0;
        rotSpeed = 0;
        isFieldOriented = true;//should be true
        gyro.reset();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Swerve Drive";
    }
    
}
