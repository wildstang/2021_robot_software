package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

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
public class Scoring implements Subsystem {

    private enum intakeStateEnum {
        CLOSED (1),
        OPEN (-1);

        private final double Speed; 

        intakeStateEnum(double speed) {
            this.Speed = speed;
        }
        
        public double speed() {
            return Speed;
        }
    }

    private intakeStateEnum intakeState; 

    private DigitalInput deployButtonDown;
    private DigitalInput intakeButton;
    private DigitalInput outputButton; 
    private DigitalInput deployButtonUp;
    private DigitalInput intakeReverseButton;

    private boolean intakeOn; 
    private boolean outputOn; 

    //motors
    public VictorSPX IntakeVictor; //intake = positive, output = negative 
    public VictorSPX IntakeDeployVictor;  //up = negative, down = positve


    // initializes the subsystem
    public void init() {
        deployButtonUp = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_UP.getName());
        deployButtonUp.addInputListener(this);
        deployButtonDown = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_DOWN.getName());
        deployButtonDown.addInputListener(this);
        intakeButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_RIGHT.getName());
        intakeButton.addInputListener(this);
        outputButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_DPAD_DOWN);
        IntakeVictor = new VictorSPX(CANConstants.Intake);
        IntakeDeployVictor = new VictorSPX(CANConstants.IntakeDeplay);
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        if(intakeOn) {
            IntakeVictor.set(ControlMode.PercentOutput, 0.5);
        }
        else if (outputOn) {
            IntakeVictor.set(ControlMode.PercentOutput, -0.5);
        }
        else {
            IntakeVictor.set(ControlMode.PercentOutput, 0);
        }

        

    }

    // respond to input updates     
    public void inputUpdate(Input signal) {
        if(intakeButton.getValue()) {
            if (outputOn) {
                outputOn = !outputOn;
            }
            intakeOn = !intakeOn;
        }

        if(outputButton.getValue()) {
            if (intakeOn) {
                intakeOn = !intakeOn;
            }
            outputOn = !outputOn;
        }

        
    }

    // used for testing
    public void selfTest() {}

    public void resetState() {
        intakeOn = false; 
        outputOn  = false; 
    }

    // returns the unique name of the example
    public String getName() {
        return "Scoring";
    }
}