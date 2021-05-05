package org.wildstang.year2021.subsystems.arm;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       Arm.java
 * Inputs:      1 AnalogInput (Manipulator left joystick Y-axis)
 * Outputs:     1 VictorSPX
 * Description: Joystick up lifts the arm, joystick down lowers the arm.
 */
public class Arm implements Subsystem {

    // inputs
    private AnalogInput leftJoystick;

    // outputs
    private VictorSPX motor;

    // variables
    private double speed = 0.0;
    private double maxSpeed = 0.8;

    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {
        leftJoystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_LEFT_JOYSTICK_Y.getName());
        leftJoystick.addInputListener(this);
    }

    public void initOutputs() {
        motor = new VictorSPX(CANConstants.ARM_VICTOR);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(ControlMode.PercentOutput, speed*maxSpeed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        if (signal == leftJoystick) {
            double stickValue = leftJoystick.getValue();
            if (Math.abs(stickValue) > 0.4) {
                speed = stickValue;
            } else {
                resetState();
            }
        } else {
            resetState();
        }
    }

    // helper method for autonomous
    public void setArmSpeed(double s) {
        speed = s;
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        speed = 0.0;
    }

    // returns the unique name of the subsystem
    public String getName() {
        return "Arm";
    }
}