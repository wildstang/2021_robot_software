package org.wildstang.year2020.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.year2020.robot.WSInputs;

public class SimpleDrive implements Subsystem {
    TalonFX left;
    TalonFX right;
    AnalogInput headingInput;
    AnalogInput throttleInput;
    double heading;
    double throttle;
    CheesyDriveHelper cheesyHelper;
    DriveSignal driveSignal;

    @Override
    public void inputUpdate(Input source) {
        if (source == throttleInput){
            throttle = -throttleInput.getValue();
        } 
        if (source == headingInput){
            heading = -headingInput.getValue();
        }

    }

    @Override
    public void init() {
        left = new TalonFX(32);
        right = new TalonFX(33);
        left.enableVoltageCompensation(true);
        right.enableVoltageCompensation(true);
        left.setInverted(TalonFXInvertType.Clockwise);
        right.setInverted(TalonFXInvertType.CounterClockwise);
        left.setNeutralMode(NeutralMode.Coast);
        right.setNeutralMode(NeutralMode.Coast);
        headingInput = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_X);
        headingInput.addInputListener(this);
        throttleInput = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y);
        throttleInput.addInputListener(this);
        cheesyHelper = new CheesyDriveHelper();
    }

    @Override
    public void selfTest() {
    }

    @Override
    public void update() {
        driveSignal = cheesyHelper.cheesyDrive(throttle, heading, true);
        left.set(ControlMode.PercentOutput, driveSignal.leftMotor);
        right.set(ControlMode.PercentOutput, driveSignal.rightMotor);
    }

    @Override
    public void resetState() {
        throttle = 0;
        heading = 0;
        driveSignal = cheesyHelper.cheesyDrive(0, 0, true);
    }

    @Override
    public String getName() {
        return "SimpleDrive";
    }
    
}
