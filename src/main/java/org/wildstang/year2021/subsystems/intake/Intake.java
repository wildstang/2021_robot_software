package org.wildstang.year2021.subsystems.intake;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
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

    // inputs
    private AnalogInput rightTrigger;

    // outputs
    private VictorSPX motor;

    // states
    private double speed;
  
  
    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        rightTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_TRIGGER_RIGHT.getName());
        rightTrigger.addInputListener(this);

        // create motor controller object with CAN Constant
        motor = new VictorSPX(CANConstants.INTAKE_ROLLER_VICTOR);

        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(ControlMode.PercentOutput, speed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == rightTrigger) {
            if(rightTrigger.getValue() > 0.5){
                speed = 20;
            } else {
                speed = 0;
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
        return "Intake";
    }
}