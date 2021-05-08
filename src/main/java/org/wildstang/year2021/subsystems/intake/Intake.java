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
 * Inputs:      2 DigitalInput (Driver left shoulder and right shoulder) 
 * Outputs:     1 VictorSPX
 * Description: Left shoulder to toggle intake backwards, right shoulder to toggle intake forwards
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
    private int intakeStatus = 0; // 0 - off; 1 - forwards; 2 - backwards

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
            if (intakeStatus == 1) {
                intakeStatus = 0;
            }
            else {
                intakeStatus = 1;
            }
        }
        if (signal == leftShoulder) {
            if (intakeStatus == 2) {
                intakeStatus = 0;
            }
            else {
                intakeStatus = 2;
            }
        }
        // set speed based on status
        if (intakeStatus == 1) {
            speed = -1.0;
        }
        else if (intakeStatus == 2) {
            speed = 1.0;
        }
        else {
            speed = 0.0;
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