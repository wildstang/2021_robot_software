package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    private enum intakeState {ON, REVERSE, OFF};
    private intakeState state;

    //Constants
    private double full_speed = -1.0;



       // initializes the subsystem
    public void init() {
        // create motor controller object with CAN Constant
        motor = new CANSparkMax(CANConstants.INTAKE_VICTOR, MotorType.kBrushless);
        button = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_SHOULDER);    
        button.addInputListener(this);
        reverseButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_DPAD_DOWN);
        reverseButton.addInputListener(this);
        resetState();
    }

    public void turnOnIntake(){
        state = intakeState.ON;
    }

    //update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        switch(state){
        case ON:
            motor.set(full_speed);
            break;
        case OFF:
            motor.set(0.0);
            break;
        case REVERSE:
            motor.set(-full_speed);
            break;
        }
        SmartDashboard.putNumber("Intake Speed", motor.get());
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (button.getValue()){
            state = intakeState.ON;
        } else if (reverseButton.getValue()){
            state = intakeState.REVERSE;
        } else {
            state = intakeState.OFF;
        }       
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        state = intakeState.OFF;
    }

    // returns the unique name of the example
    public String getName() {
        return "Intake";
    }
}