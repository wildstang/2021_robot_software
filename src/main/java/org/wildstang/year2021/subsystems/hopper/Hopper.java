package org.wildstang.year2021.subsystems.hopper;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import javax.lang.model.util.ElementScanner6;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       Hopper.java
 * Inputs:      1 DigitalInput (X button)
 * Outputs:     1 VictorSPX
 * Description: X button toggles hopper flap, press once to open, press again to close
 */
public class Hopper implements Subsystem {

    // inputs
    private DigitalInput xButton;

    // outputs
    private VictorSPX motor;

    // states
    private double speed;

    private double multiplier = 10;

    private int moveTimerTime = 400;

    private int moveTimer;

    private boolean open;

    private boolean toggle;
    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        xButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_LEFT.getName());
        xButton.addInputListener(this);

        // create motor controller object with CAN Constant
        motor = new VictorSPX(CANConstants.HOPPER_VICTOR);
        moveTimer = moveTimerTime;
        open = false;
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        if(toggle&&moveTimer==moveTimerTime){
            open = !open;
            moveTimer--;
        }
        if(open&&moveTimer>0&&moveTimer<moveTimerTime){
        motor.set(ControlMode.PercentOutput, multiplier);
        moveTimer--;
        }
        else if(moveTimer>0&&moveTimer<moveTimerTime){
        motor.set(ControlMode.PercentOutput, multiplier*-1);
        moveTimer--;
        }
        else
            resetState();
        if(!toggle&&moveTimer==0){
            moveTimer=moveTimerTime;
        }
        
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == xButton) {
            if(xButton.getValue())
                toggle = true;
            else
                toggle = false;
        }
        else
            toggle = false;
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