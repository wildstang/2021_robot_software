package org.wildstang.year2021.subsystems.intake;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       Intake.java
 * Inputs:      AnalogInput (Right trigger) 
 * Outputs:     1 VictorSPX
 * Description: After pressing the right trigger by a certain amount (0.5), the intake roller will start moving at full speed.
 */
public class Intake implements Subsystem {


    /**
     *
     */

    // inputs
    private AnalogInput rightTrigger;

    // outputs
    private VictorSPX rollerMotor;
   

    // states
    private double speed;
    

    //helpful variables
    private double maxSpeed = 0.8; //this is just where we can set a consecutive speed, for convinience, instead of changing the speed in each area implemented every time we change it

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        rightTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_TRIGGER_RIGHT.getName());
        rightTrigger.addInputListener(this);

        // create rollerMotor controller object with CAN Constant
        rollerMotor = new VictorSPX(CANConstants.INTAKE_ROLLER_VICTOR);

        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        rollerMotor.set(ControlMode.PercentOutput, speed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == rightTrigger) {
            if(rightTrigger.getValue() > 0.5){
                speed = maxSpeed;
                //when right trigger is pressed past halfway, the intake spins at speed <speedValue>
            } else {
                resetState();
            }
        } else {
            resetState();
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
        return "Intake";
    }

    
    
}