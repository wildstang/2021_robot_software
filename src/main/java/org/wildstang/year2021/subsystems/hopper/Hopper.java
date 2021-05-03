package org.wildstang.year2021.subsystems.hopper;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       Hopper.java
 * Inputs:      1 AnalogInput (Right Joystick)
 * Outputs:     1 VictorSPX
 * Description: Push right joystick up to roll hopper forwards, and down to roll it backwards.
 */
public class Hopper implements Subsystem {

    // inputs
    private AnalogInput rightJoystick;

    // outputs
    private VictorSPX motor;

    // states
    private double speed = 0;
    private double multiplier = 10;
    

    // initializes the subsystem
    public void init() {
        // register joystick and attach input listener with WS Input
        rightJoystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_Y.getName());
        rightJoystick.addInputListener(this);
        
        // create motor controller object with CAN Constant
        motor = new VictorSPX(CANConstants.HOPPER_VICTOR);
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
            motor.set(ControlMode.PercentOutput, speed*multiplier);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == rightJoystick){
            
                if(rightJoystick.getValue() > 0.5){
                speed = 1.0;
                }
                
                if(rightJoystick.getValue() < -0.5){
                speed = -1.0; 
                }
            }
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
