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
 * Inputs:      2 AnalogInput (Manipulator left trigger and right trigger) 
 * Outputs:     1 VictorSPX
 * Description: Right trigger to roll intake forwards, left trigger to roll intake backwards (if right trigger is not being pressed).
 */
public class Intake implements Subsystem {

    // inputs
    private AnalogInput rightTrigger;
    private AnalogInput leftTrigger;

    // outputs
    private VictorSPX rollerMotor;

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
        rightTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_RIGHT_TRIGGER.getName());
        rightTrigger.addInputListener(this);
        leftTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_LEFT_TRIGGER.getName());
        leftTrigger.addInputListener(this);
    }

    public void initOutputs() {
        rollerMotor = new VictorSPX(CANConstants.INTAKE_ROLLER_VICTOR);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        rollerMotor.set(ControlMode.PercentOutput, speed*maxSpeed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        if (signal == rightTrigger || signal == leftTrigger) {
            if (rightTrigger.getValue() > 0.2) {
                speed = rightTrigger.getValue();
                // when right trigger is pressed 20%, the intake spins forwards
            }
            else if (leftTrigger.getValue() > 0.2) {
                speed = leftTrigger.getValue() * -1.0;
                // when left trigger is pressed 20%, the intake spins backwards
            }
            else {
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

//coutesy of Shane Thomas