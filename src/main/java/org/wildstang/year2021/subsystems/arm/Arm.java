package org.wildstang.year2021.subsystems.arm;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

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
    private DigitalInput dPadUp;
    private DigitalInput dPadDown;

    // outputs
    private VictorSPX motor;

    // states
    private double speed;
    private double speedMult = 0.8;

    private boolean armMoving = false;
    private double originalPosition = motor.getActiveTrajectoryPosition();
    private double positionChange = 0;
    private double armRotation = 0;
    private boolean armMovingUp;

    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {
        IInputManager inputManager = Core.getInputManager();
        dPadUp = (DigitalInput) inputManager.getInput(WSInputs.DRIVER_DPAD_UP.getName());
        dPadUp.addInputListener(this);
        dPadDown = (DigitalInput) inputManager.getInput(WSInputs.DRIVER_DPAD_DOWN.getName());
        dPadDown.addInputListener(this);
    }

    public void initOutputs() {
        motor = new VictorSPX(CANConstants.ARM_VICTOR);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(ControlMode.PercentOutput, speed);
        if (armMoving == true) {
            updateAutoArmMove();
        }
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == dPadUp) {
            speed = speedMult;
        } else if (signal == dPadDown) {
            speed = -speedMult;
        } else {
            speed = 0;
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

    // allows auto to move the arm based on the amount the motor should rotate
    // I'm not sure if motor.getActiveTrajectoryPosition() is actually what gets the motor's currect position but it's my best guess.
    // also yes I'm aware that this is incredibly inefficient and dumb but I couldn't figure out a way to make it work without all billion global variables.
    public void moveArm(double rotation, boolean up) {
        armMoving = true;
        armRotation = rotation;
        armMovingUp = up;
        originalPosition = motor.getActiveTrajectoryPosition();
        positionChange = 0;
    }

    // updates with every tick of the update() function
    public void updateAutoArmMove() {
        if (positionChange <= armRotation) {
            if (armMovingUp == true) {
                speed = speedMult;
            } else {
                speed = -speedMult;
            }
            // tracks how much the arm has moved
            positionChange = Math.abs(motor.getActiveTrajectoryPosition() - originalPosition);
        } else {
            speed = 0;
            armMoving = false;
        }
    }


}