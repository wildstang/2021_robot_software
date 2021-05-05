package org.wildstang.year2021.subsystems.hopper;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       Hopper.java
 * Inputs:      1 AnalogInput (Manipulator right joystick Y-axis)
 * Outputs:     1 VictorSPX
 * Description: Joystick up to roll hopper forwards, joystick down to roll it backwards.
 */
public class Hopper implements Subsystem {

    // inputs
    private AnalogInput rightJoystick;

    // outputs
    private VictorSPX motor;

    // variables
    private double speed = 0.0;
    private double maxSpeed = 1.0;
    
    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {
        rightJoystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_RIGHT_JOYSTICK_Y.getName());
        rightJoystick.addInputListener(this);
    }

    public void initOutputs() {
        motor = new VictorSPX(CANConstants.HOPPER_VICTOR);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(ControlMode.PercentOutput, speed*maxSpeed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        if (signal == rightJoystick){
            if (rightJoystick.getValue() > 0.4){
                speed = 1.0;
            }
            else if (rightJoystick.getValue() < -0.4){
                speed = -1.0; 
            }
            else {
                resetState();
            }
        }
        else {
            resetState();
        }
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        speed = 0.0;
    }

    // returns the unique name of the subsystem
    public String getName() {
        return "Hopper";
    }
}
