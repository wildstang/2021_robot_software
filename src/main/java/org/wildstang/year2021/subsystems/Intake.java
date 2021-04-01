package org.wildstang.year2021.subsystems;
 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
 
import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

/**
 * Class:       Intake.java
 * Inputs:      1 analog button
 * Outputs:     1 victor
 * Description: This turns on and off the intake & ball elevator based on an analog button. 
 */

public class Intake implements Subsystem {

    // inputs
    private AnalogInput intakeButton;

    // outputs
    private VictorSPX intakeMotor;

    // states
    private boolean isRunning;

    // set values
    private final double runSpeed = 0.5;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        intakeButton = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_SHOULDER_LEFT.getName());
        intakeButton.addInputListener(this);

        // create motor controller object with CAN Constant
        intakeMotor = new VictorSPX(CANConstants.INTAKE_MOTOR);

        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        //motor.set(ControlMode.PercentOutput, speed);
        if (isRunning) {
            intakeMotor.set(ControlMode.PercentOutput, runSpeed);
        } else if (!isRunning) {
            intakeMotor.set(ControlMode.PercentOutput, 0);
        }
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == intakeButton) {
            if (isRunning) { // on -> off
                isRunning = false;
            } else if (!isRunning) { // off -> on
                isRunning = true;
            }
        }
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        isRunning = false;
        intakeMotor.set(ControlMode.PercentOutput, 0);
    }

    // returns the unique name of the example
    public String getName() {
        return "Intake Subsystem";
    }
}