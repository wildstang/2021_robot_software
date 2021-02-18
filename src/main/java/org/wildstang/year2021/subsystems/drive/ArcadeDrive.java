package org.wildstang.year2021.subsystems.drive;

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
    private AnalogInput joystickLeftY;
    private AnalogInput joystickLeftX;

    // outputs
    private TalonSRX motorLeft;
    private TalonSRX motorRight;

    // states
    private double leftSpeed;
    private double rightSpeed;

    private double speedMult = 20;

    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {
        joystickLeftX = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_X.getName());
        joystickLeftX.addInputListener(this);
        joystickLeftY = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y.getName());
        joystickLeftY.addInputListener(this);
    }

    public void initOutputs() {
        motorLeft = new TalonSRX(CANConstants.EXAMPLE_CONTROLLER);
        motorRight = new TalonSRX(CANConstants.EXAMPLE_CONTROLLER);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motorLeft.set(ControlMode.PercentOutput, leftSpeed);
        motorRight.set(ControlMode.PercentOutput, rightSpeed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        if (signal == joystickLeftX || signal == joystickLeftY) {
            if(Math.abs(joystickLeftY.getValue())>0.1&&Math.abs(joystickLeftX.getValue())>0.1){
            leftSpeed = (joystickLeftY.getValue() + joystickLeftX.getValue()) * speedMult;
            rightSpeed = (joystickLeftY.getValue() - joystickLeftX.getValue()) * speedMult;
            }
        
        else {
            resetState();
            }
        }
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        leftSpeed = 0;
        rightSpeed = 0;
    }

    public String getName() {
        return "Arcade Drive";
    }
}