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
 * Inputs:      AnalogInput (Manipulator Left and Right trigger) 
 * Outputs:     1 VictorSPX
 * Description: After pressing the left/right trigger by a certain amount (0.2), the intake roller will start moving at however far the trigger is pushed.
 */
public class Intake implements Subsystem {

    // inputs
    private AnalogInput rightTrigger;
    private AnalogInput leftTrigger;

    // outputs
    private VictorSPX rollerMotor;

    // states
    private double speed;

    //helpful variables
    private double maxSpeed = 0.8;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        rightTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_RIGHT_TRIGGER.getName());
        rightTrigger.addInputListener(this);
        leftTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_LEFT_TRIGGER.getName());
        leftTrigger.addInputListener(this);

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
        if (signal == rightTrigger || signal == leftTrigger) {
            if (rightTrigger.getValue() > 0.2) {
                speed = rightTrigger.getValue() * maxSpeed;
                // when right trigger is pressed 20%, the intake spins forward
            }
            else if (leftTrigger.getValue() > 0.2) {
                speed = leftTrigger.getValue() * maxSpeed * -1.0;
                // when left trigger is pressed 20%, the intake spins backwards
            }
            else {
                resetState();
            }
        } else {
            resetState();
        }
    }

    public void setIntakeSpeed(double i){
        speed = i;
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