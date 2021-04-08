package org.wildstang.year2021.subsystems.hopper;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       Hopper.java
 * Inputs:      1 DigitalInput (X button)
 * Outputs:     1 VictorSPX
 * Description: Press X button to roll, press again to stop
 */
public class Hopper implements Subsystem {

    // inputs
    private DigitalInput xButton;

    // outputs
    private VictorSPX motor;

    // states
    private double speed = 0;
    private double multiplier = 10;
    private boolean isRolling;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        xButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_LEFT.getName());
        xButton.addInputListener(this);
        
        isRolling = false;

        // create motor controller object with CAN Constant
        motor = new VictorSPX(CANConstants.HOPPER_VICTOR);
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        if (isRolling){
            speed = 1.0;
        }
        else{
            resetState();
        }
            motor.set(ControlMode.PercentOutput, speed*multiplier);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == xButton)
            isRolling = !isRolling;
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        speed = 0.0;
    }

    // returns the unique name of the example
    public String getName() {
        return "Hopper";
    }
}