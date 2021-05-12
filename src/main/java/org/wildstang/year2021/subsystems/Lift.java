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
public class Lift implements Subsystem {

    // inputs
    private DigitalInput up;
    private DigitalInput down;
    private DigitalInput limit;

    // outputs
    private VictorSPX motor;

    // states
    private double speed;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        up = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_DPAD_UP.getName());
        down = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_DPAD_DOWN.getName());
        limit = (DigitalInput) Core.getInputManager().getInput(WSInputs.LIFT_LIMIT.getName());

        
        limit.addInputListener(this);
        up.addInputListener(this);
        down.addInputListener(this);

        // create motor controller object with CAN Constant
      
        motor = new VictorSPX(CANConstants.LIFT_TALON);
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(ControlMode.PercentOutput, speed);
       //System.out.println(speed);
    }

    public void deployLift(){
        speed = 1;
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if ((signal == up || signal == limit) && up.getValue() && limit.getValue()) {
            speed = 0.5;
        }else if(signal == down && down.getValue()){
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
        return "Lift";
    }
}