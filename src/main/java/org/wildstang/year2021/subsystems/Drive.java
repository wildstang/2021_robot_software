package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.year2021.robot.CANConstants;

/**
 * Class:       TestSubsystem.java
 * Inputs:      1 joystick
 * Outputs:     1 talon
 * Description: This is a testing subsystem that controls a single motor with a joystick.
 */
public class Drive implements Subsystem {

    //MM_DRIVE(3, new PIDConstants(0.0, .2, 0.001, 2));

    // constants 
     private double SPEED_MOD;

    // inputs
    private AnalogInput forwardTranslationStick;
    private AnalogInput sidewaysTranslationStick;
    private AnalogInput rotationStick; 

    double forwardTranslationInput; 
    double sidewaysTranslationInput;
    double RotationInput; 

    double leftSpeed;
    double rightSpeed;
    double centerSpeed;

    double rotationMod; 
    double leftOverflow;
    double rightOverflow;

    // outputs
    private VictorSPX leftMotor;
    private VictorSPX rightMotor; 
    private VictorSPX centerMotor; 
    private VictorSPX centerFollower;


    public double LogInput(AnalogInput stick) {
        if (stick.getValue() > 0.1) {
            return Math.pow(stick.getValue(), 2);
        }
        else if ((stick.getValue() < -0.1)) {
            return -1 * Math.pow(stick.getValue(), 2);
        }
        else {
            return 0;
        }
    }
    

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        forwardTranslationStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y.getName());
        sidewaysTranslationStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_X.getName());
        rotationStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_X.getName());

        forwardTranslationStick.addInputListener(this);
        sidewaysTranslationStick.addInputListener(this);
        rotationStick.addInputListener(this);

        leftMotor = new VictorSPX(CANConstants.LeftDriveTalon);
        rightMotor = new VictorSPX(CANConstants.RightDriveTalon);
        leftMotor.setInverted(true);
        
        centerMotor = new VictorSPX(CANConstants.CenterDriveTalon1);
        centerFollower = new VictorSPX(CANConstants.CenterDriveTalon2);
        centerFollower.follow(centerMotor);
        centerMotor.setInverted(false);

        

        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        if(forwardTranslationInput != 0) {
            leftSpeed = forwardTranslationInput * (RotationInput - 1) * -1;
            rightSpeed = forwardTranslationInput * (RotationInput + 1);
            /*
            if (Math.abs(leftSpeed) > 1) {
                rightSpeed -= ((leftSpeed * 0.9999) % 1);
            }
            if (Math.abs(rightSpeed) > 1) {
                leftSpeed -= ((rightSpeed * 0.9999) % 1);
            }
           */
        }   
        else {
            leftSpeed = -RotationInput;
            rightSpeed = RotationInput;
        }
        
        leftMotor.set(ControlMode.PercentOutput, leftSpeed);
        rightMotor.set(ControlMode.PercentOutput, rightSpeed);
        centerMotor.set(ControlMode.PercentOutput, (sidewaysTranslationInput * -1));
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        forwardTranslationInput = LogInput(forwardTranslationStick);
        RotationInput = LogInput(rotationStick);
        sidewaysTranslationInput = LogInput(sidewaysTranslationStick);
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        
    }

    // returns the unique name of the example
    public String getName() {
        return "Drive";
    }
}