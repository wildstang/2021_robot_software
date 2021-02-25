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
 * Description: A tank drive system that controls two motors.
 */
public class TankDrive implements Subsystem {

    // inputs
    private AnalogInput leftJoystick;
    private AnalogInput rightJoystick;

    // outputs
    private VictorSPX leftMotor;
    private VictorSPX rightMotor;

    // states
    private double speed;
    private double multiplier = 35; // for 35 MPH

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
        leftMotor = new VictorSPX(CANConstants.LEFT_DRIVE_VICTOR_FRONT);
        rightMotor = new VictorSPX(CANConstants.LEFT_DRIVE_VICTOR_BACK);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        leftMotor.set(ControlMode.PercentOutput, speed);
        rightMotor.set(ControlMode.PercentOutput, speed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == leftJoystick) {
            speed = leftJoystick.getValue() * multiplier;
        }
        if (signal == rightJoystick) {
            speed = rightJoystick.getValue() * multiplier;
        }
    }

    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        speed = 0.0;
    }

    // returns the unique name of the example
    public String getName() {
        return "Tank drive";
    }
}