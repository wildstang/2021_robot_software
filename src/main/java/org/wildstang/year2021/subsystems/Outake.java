package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       TestSubsystem.java
 * Inputs:      1 joystick
 * Outputs:     1 talon
 * Description: This is a testing subsystem that controls a single motor with a joystick.
 */
public class Outake implements Subsystem {

    // inputs
    private DigitalInput up;
    private DigitalInput down;
    private DigitalInput manipUp;
    private DigitalInput manipDown;
    private DigitalInput limit;

    // outputs
    private VictorSPX motor;

    // states
    private double speed;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        down = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_SHOULDER_LEFT.getName());
        up = (DigitalInput) Core.getInputManager().getInput(WSInputs. DRIVER_SHOULDER_RIGHT.getName());
        limit = (DigitalInput) Core.getInputManager().getInput(WSInputs.OUTAKE_LIMIT.getName());

        manipUp = (DigitalInput) Core.getInputManager().getInput(WSInputs. MANIPULATOR_SHOULDER_RIGHT.getName());
        manipDown = (DigitalInput) Core.getInputManager().getInput(WSInputs. MANIPULATOR_SHOULDER_LEFT.getName());
        
        limit.addInputListener(this);
        up.addInputListener(this);
        down.addInputListener(this);
        manipUp.addInputListener(this);
        manipDown.addInputListener(this);


        // create motor controller object with CAN Constant
      
        motor = new VictorSPX(CANConstants.OUTAKE_TALON);
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(ControlMode.PercentOutput, speed);
       //System.out.println(speed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
     
        if (((signal == up || signal == limit) && up.getValue() && limit.getValue()) || ((signal == manipUp || signal == limit) && manipUp.getValue() && limit.getValue())) {
            speed = 0.5;
        }else if((signal == down && down.getValue()) || (signal == manipDown && manipDown.getValue())){
            speed = -0.5;
        }else{
            speed = 0;
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
        return "Outake";
    }
}