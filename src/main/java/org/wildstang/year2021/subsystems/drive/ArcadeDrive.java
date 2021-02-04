package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       ArcadeDrive.java
 */
public class ArcadeDrive implements Subsystem {

    // inputs
    private AnalogInput joystick;

    // outputs
    private TalonSRX motor;

    // states
    private double speed;

    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {

    }

    public void initOutputs() {

    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
    }

    public String getName() {
        return "Arcade Drive";
    }
}