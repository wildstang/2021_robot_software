package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       TestSubsystem.java
 * Inputs:      1 joystick
 * Outputs:     1 talon
 * Description: This is a testing subsystem that controls a single motor with a joystick.
 */
public class Intake implements Subsystem {

    // inputs
    private DigitalInput button;
    private DigitalInput reverseButton; 

    // outputs
    private CANSparkMax motor;

    // states
    private double intakeSpeed;
    private boolean isRunning = false;

    //Constants
    private double full_speed;



       // initializes the subsystem
    public void init() {
        // create motor controller object with CAN Constant
        motor = new CANSparkMax(CANConstants.INTAKE_VICTOR, MotorType.kBrushless);
        button = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_SHOULDER_LEFT);    
        button.addInputListener(this);
        resetState();
    }

    public void turnOnIntake(){
        isRunning = true;
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(intakeSpeed);

        /*
        if(isRunning == true){
            intakeSpeed = full_speed;
        }else if(isRunning == false){
            intakeSpeed = 0.0;        
        }
        */
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (button.getValue()){
            intakeSpeed = -1.0;
        }
        else if (reverseButton.getValue()) {
            intakeSpeed = 1.0;
        }
        else {
            intakeSpeed = 0.0; 

        }
       
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        intakeSpeed = 0.0;
    }

    // returns the unique name of the example
    public String getName() {
        return "Intake";
    }
}