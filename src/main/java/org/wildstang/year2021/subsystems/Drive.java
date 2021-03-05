    ipackage org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

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
    // outputs
    private TalonSRX leftMotor;
    private TalonSRX rightMotor; 
    private TalonSRX centerMotor; 
    private TalonSRX centerFollower;

    
    

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        forwardTranslationStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y.getName());
        sidewaysTranslationStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_X.getName());
        rotationStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_X.getName());

        forwardTranslationStick.addInputListener(this);
        sidewaysTranslationStick.addInputListener(this);
        rotationStick.addInputListener(this);

        leftMotor = new TalonSRX(CANConstants.LeftDriveTalon);
        rightMotor = new TalonSRX(CANConstants.RightDriveTalon);
        centerMotor = new TalonSRX(CANConstants.CenterDriveTalon1);
        centerFollower = new TalonSRX(CANConstants.CenterDriveTalon2);
        centerFollower.follow(centerMotor);

        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        leftSpeed = forwardTranslationInput + (RotationInput / 5); 
        rightSpeed = forwardTranslationInput - (RotationInput / 5);
        leftMotor.set(ControlMode.PercentOutput, leftSpeed);
        rightMotor.set(ControlMode.PercentOutput, rightSpeed);
        centerMotor.set(ControlMode.PercentOutput,sidewaysTranslationInput);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        forwardTranslationInput = 0.8 * Math.pow(forwardTranslationStick.getValue(), 2);
        sidewaysTranslationInput = 0.8 * Math.pow(sidewaysTranslationStick.getValue(), 2);
        forwardTranslationInput = Math.pow(rotationStick.getValue(), 2);
        if(forwardTranslationStick.getValue() < 0) {
            forwardTranslationInput *= -1;
        }
        if(sidewaysTranslationStick.getValue() < 0) {
            sidewaysTranslationInput *= -1;
        }
        if(rotationStick.getValue() < 0) {
            RotationInput *= -1;
        }
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