package org.wildstang.year2021.subsystems.intake;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       Intake.java
 * Inputs:      2 AnalogInput (Manipulator left trigger and right trigger) 
 * Outputs:     1 VictorSPX
 * Description: Right trigger to roll intake forwards, left trigger to roll intake backwards (if right trigger is not being pressed).
 */
public class Intake implements Subsystem {

    // inputs
    private DigitalInput rightShoulder;
    private DigitalInput leftShoulder;

    // outputs
    private VictorSPX rollerMotor;

    // variables
    private double speed = 0.0;
    private double maxSpeed = 0.5;

    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {
        rightShoulder = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_SHOULDER.getName());
        rightShoulder.addInputListener(this);
        leftShoulder = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_SHOULDER.getName());
        leftShoulder.addInputListener(this);
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
        if (signal == rightShoulder) {
            if (rightShoulder.getValue()) {
                speed = -1.0;
                System.out.println("Intake forwards!");
                // when right trigger is pressed 20%, the intake spins forwards
            }
            else {
                resetState();
            }
        } else {
            resetState();
        }
        if (signal == leftShoulder) {
            if (leftShoulder.getValue()) {
                speed = 1.0;
                System.out.println("Intake backwards!");
                // when left trigger is pressed 20%, the intake spins backwards
            }
            else {
                resetState();
            }
        }
    }

    // helper methods for autonomous
    public void setIntakeSpeed(double i){
        speed = i;
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        speed = 0.0;
    }

    // returns the unique name of the subsystem
    public String getName() {
        return "Intake";
    }
}

//coutesy of Shane Thomas