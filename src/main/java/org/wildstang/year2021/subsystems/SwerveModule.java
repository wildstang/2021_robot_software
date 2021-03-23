package org.wildstang.year2021.subsystems;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Units;

public class SwerveModule {

    private static final double driveP = 15.0;
    private static final double driveI = 0.01;
    private static final double driveD = 0.1;
    private static final double driveF = 0.00581;
    private static final double angleP = 0.5;
    private static final double angleI = 0.0;
    private static final double angleD = 0.0001;

    private double encoderTicksPerRot = 1;//for neo integrated encoder
    private double gearRatio = 12.8;//15:32 and 10:60 gear ratio for angle motor
    private double driveGearRatio = 6.86;//MK3 fast gearing
    private double wheelDiameter = 4.0;//inches

    private double target;
    private double drivePower;

    private CANSparkMax driveMotor;
    private CANSparkMax angleMotor;
    private CANPIDController driveController;
    private CANPIDController angleController;
    private CANCoder canCoder;

    public SwerveModule(CANSparkMax driveMotor, CANSparkMax angleMotor, CANCoder canCoder, Rotation2d offset){
        this.driveMotor = driveMotor;
        this.angleMotor = angleMotor;
        this.canCoder = canCoder;
        this.driveMotor.setIdleMode(IdleMode.kCoast);
        this.angleMotor.setIdleMode(IdleMode.kBrake);

        //set up angle and drive with pid and kpid respectively
        driveController = driveMotor.getPIDController();
        angleController = angleMotor.getPIDController();
        driveController.setP(driveP);
        driveController.setI(driveI);
        driveController.setD(driveD);
        driveController.setFF(driveF);
        angleController.setP(angleP);
        angleController.setI(angleI);
        angleController.setD(angleD);
        

        CANCoderConfiguration canCoderConfiguration = new CANCoderConfiguration();
        canCoderConfiguration.magnetOffsetDegrees = offset.getDegrees();
        canCoder.configAllSettings(canCoderConfiguration);

    }
    public Rotation2d getAngle(){
        return Rotation2d.fromDegrees(canCoder.getAbsolutePosition());
    }
    public void setDesiredState(SwerveModuleState desiredState){
        Rotation2d currentRotation = getAngle();
        SwerveModuleState state = SwerveModuleState.optimize(desiredState, currentRotation);
        Rotation2d rotationDelta = state.angle.minus(currentRotation);//rotation to complete move
        double deltaTicks = (rotationDelta.getDegrees()/360)*encoderTicksPerRot*gearRatio;//finds rotations of neo motor encoder needed
        //double currentTicks = canCoder.getPosition() / canCoder.configGetFeedbackCoefficient();//for cancoder
        double currentTicks = angleMotor.getEncoder().getPosition();//finds delta of neo motor encoder
        double desiredTicks = currentTicks + deltaTicks;//neo motor encoder target ticks for position loop
        
        //set angle motor to track to desiredTicks
        angleController.setReference(desiredTicks, ControlType.kPosition); target = desiredTicks;

        double feetPerSecond = Units.metersToFeet(state.speedMetersPerSecond);
        driveMotor.set(feetPerSecond / SwerveDrive.maxSpeed); drivePower = feetPerSecond/SwerveDrive.maxSpeed;
    }
    public void displayNumbers(String name){
        SmartDashboard.putNumber(name + " CANCoder", canCoder.getAbsolutePosition());
        SmartDashboard.putNumber(name + " NEO angle encoder", angleMotor.getEncoder().getPosition());
        SmartDashboard.putNumber(name + " NEO angle target", target);
        SmartDashboard.putNumber(name + " NEO drive power", drivePower);
    }
    public void resetDriveEncoders(){
        driveMotor.getEncoder().setPosition(0.0);
    }
    public void setDriveBrake(boolean isBrake){
        if(isBrake){
            driveMotor.setIdleMode(IdleMode.kBrake); 
        } else {
            driveMotor.setIdleMode(IdleMode.kCoast);
        }
    }
    public void runAtAngle(double angle){
        double currentRotation = getAngle().getDegrees();
        double deltaRotation = currentRotation - angle;
        double deltaTicks = deltaRotation/360 * encoderTicksPerRot * gearRatio;
        double currentTicks = angleMotor.getEncoder().getPosition();
        angleController.setReference(currentTicks + deltaTicks, ControlType.kPosition);
        //angleMotor.set(ControlMode.Position, angle);
    }
    public void runAtPower(double power){
        driveMotor.set(power);
    }
    public double getDriveF(){
        return driveF;
    }
    public double getDriveP(){
        return driveP;
    }
    public double getPosition(){
        return driveMotor.getEncoder().getPosition() * wheelDiameter * Math.PI / driveGearRatio;
    }
}
