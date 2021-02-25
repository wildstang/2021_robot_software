package org.wildstang.year2021.subsystems.drive;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       TankDrive.java
 * Inputs:      2 joysticks
 * Outputs:     4 VictorSPX
 * Description: A tank drive system that controls four motors.
 */
public class TankDrive implements Subsystem {

    // inputs
    private AnalogInput leftJoystick;
    private AnalogInput rightJoystick;

    // outputs
    private VictorSPX leftFrontMotor;
    private VictorSPX leftBackMotor;
    private VictorSPX rightFrontMotor;
    private VictorSPX rightBackMotor;

    // states
    private double leftSpeed;
    private double rightSpeed;
    private double multiplier = 20; // change to adjust max speed

    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {
        leftJoystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y.getName());
        leftJoystick.addInputListener(this);
        rightJoystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_Y.getName());
        rightJoystick.addInputListener(this);
    }

    public void initOutputs() {
        leftFrontMotor = new VictorSPX(CANConstants.LEFT_DRIVE_VICTOR_FRONT);
        leftBackMotor = new VictorSPX(CANConstants.LEFT_DRIVE_VICTOR_BACK);
        rightFrontMotor = new VictorSPX(CANConstants.RIGHT_DRIVE_VICTOR_FRONT);
        rightBackMotor = new VictorSPX(CANConstants.RIGHT_DRIVE_VICTOR_BACK);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed);
        leftBackMotor.set(ControlMode.PercentOutput, leftSpeed);
        rightFrontMotor.set(ControlMode.PercentOutput, rightSpeed);
        rightBackMotor.set(ControlMode.PercentOutput, rightSpeed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == leftJoystick) {
            leftSpeed = leftJoystick.getValue() * multiplier;
        }
        if (signal == rightJoystick) {
            rightSpeed = rightJoystick.getValue() * multiplier;
        }
    }

    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        leftSpeed = 0.0;
        rightSpeed = 0.0;
    }

    // returns the unique name of the example
    public String getName() {
        return "Tank Drive";
    }
}