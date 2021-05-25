package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.subsystems.DriveConstants;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveModule {

    private double target;
    private double drivePower;

    private CANSparkMax driveMotor;
    private CANSparkMax angleMotor;
    private CANPIDController driveController;
    private CANPIDController angleController;
    private CANCoder canCoder;

    public SwerveModule(CANSparkMax driveMotor, CANSparkMax angleMotor, CANCoder canCoder, double offset){
        this.driveMotor = driveMotor;
        this.angleMotor = angleMotor;
        this.canCoder = canCoder;
        this.driveMotor.setIdleMode(IdleMode.kCoast);
        this.angleMotor.setIdleMode(IdleMode.kBrake);

        //set up angle and drive with pid and kpid respectively
        driveController = driveMotor.getPIDController();
        angleController = angleMotor.getPIDController();
        driveController.setP(DriveConstants.DRIVE_P);
        driveController.setI(DriveConstants.DRIVE_I);
        driveController.setD(DriveConstants.DRIVE_D);
        driveController.setFF(DriveConstants.DRIVE_F);
        angleController.setP(DriveConstants.ANGLE_P);
        angleController.setI(DriveConstants.ANGLE_I);
        angleController.setD(DriveConstants.ANGLE_D);
        

        CANCoderConfiguration canCoderConfiguration = new CANCoderConfiguration();
        canCoderConfiguration.magnetOffsetDegrees = offset;
        canCoder.configAllSettings(canCoderConfiguration);

    }
    public double getAngle(){
        return canCoder.getAbsolutePosition();
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
    public void run(double power, double angle){
        if (getDirection(angle)){
            runAtPower(power);
            runAtAngle(angle);
        } else {
            runAtPower(-power);
            runAtAngle((angle+180.0)%360);
        }
    }
    public void runAtAngle(double angle){
        double currentRotation = getAngle();

        if (currentRotation > 180 && angle+180<currentRotation){
            currentRotation-=360.0;
        } else if (angle>180 && currentRotation+180<angle){
            currentRotation+=360.0;
        }
        
        double deltaRotation = -currentRotation + angle;
        double deltaTicks = deltaRotation/360 * DriveConstants.TICKS_PER_REV * DriveConstants.ANGLE_RATIO;
        double currentTicks = angleMotor.getEncoder().getPosition();
        angleController.setReference(currentTicks + deltaTicks, ControlType.kPosition);
        //angleMotor.set(ControlMode.Position, angle);
    }
    public void runAtPower(double power){
        driveMotor.set(power);
    }
    public double getPosition(){
        return driveMotor.getEncoder().getPosition() * DriveConstants.WHEEL_DIAMETER * Math.PI / DriveConstants.DRIVE_RATIO;
    }
    public boolean getDirection(double angle){
        if (angle > getAngle()){
            if (angle - getAngle() < 90) return true;
            if (angle - getAngle() > 270) return true;
        } else {
            if (getAngle() - angle < 90) return true;
            if (getAngle() - angle > 270) return true;
        }
        return false;
    }
}
