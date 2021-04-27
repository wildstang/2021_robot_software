package org.wildstang.year2021.subsystems.arm;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import edu.wpi.first.wpilibj.AnalogInput;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.IInputManager;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       Arm.java
 * Inputs:      2 DigitalInput (DPAD up and DPAD down)
 * Outputs:     1 VictorSPX
 * Description: DPAD up runs the motor one way to lift the arm, DPAD down runs the motor the oppposite way to lower the arm
 */
public class Arm implements Subsystem {

    // inputs
    private AnalogInput controllerStick;

    // outputs
    private VictorSPX motor;

    // states
    private double speed = 0;

    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {
        IInputManager inputManager = Core.getInputManager();
        controllerStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_LEFT_JOYSTICK_Y.getName());
        controllerStick.addInputListener(this);
    }

    public void initOutputs() {
        motor = new VictorSPX(CANConstants.ARM_VICTOR);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(ControlMode.PercentOutput, speed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see if the stick has been moved enough to warrent the arm to move
        if (signal == controllerStick) {
            double stickValue = controllerStick.getValue();
            if (Math.abs(stickValue) >= 0.4) {
                speed = stickValue;
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
        return "Arm";
    }

    public void setArmSpeed(double armSpeed) {
        speed = armSpeed;
    }
}