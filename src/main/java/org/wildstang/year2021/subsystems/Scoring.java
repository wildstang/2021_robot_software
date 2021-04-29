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
   
    private static final int DEPLOYTIME = 30; 
    private static final int AUTODEPLOYTIME = 5; 
    
    private int timer; 

    private intakeStateEnum intakeState; 

    private DigitalInput deployButton;
    private DigitalInput intakeButton;
    private DigitalInput intakeReverseButton;

    private double intakeSpeed = 0; 


    //motors
    public VictorSPX IntakeVictor;
    public VictorSPX IntakeDeployVictor; 


    // initializes the subsystem
    public void init() {
        deployButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_DOWN.getName());
        deployButton.addInputListener(this);
        intakeButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_RIGHT.getName());
        intakeButton.addInputListener(this);
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        /*
        if (timer > 0) {
            IntakeDeployVictor.set(ControlMode.PercentOutput, intakeState.speed());
            timer--;
        }
        IntakeVictor.set(ControlMode.PercentOutput, intakeSpeed);
        */  
    }

    // respond to input updates     
    public void inputUpdate(Input signal) {
        if (deployButton.getValue() && timer < 1) {
            if(intakeState == intakeStateEnum.CLOSED ) {
                intakeState = intakeStateEnum.OPEN;
                timer = DEPLOYTIME;
            }
            else if (intakeState == intakeStateEnum.OPEN) {
                intakeState = intakeStateEnum.CLOSED;
                timer = DEPLOYTIME;
            }
        }


        if(intakeButton.getValue()) {
            intakeSpeed = 1.0;
        }
        else if(intakeReverseButton.getValue()) {
            intakeSpeed = -1.0;
        }
        else {
            intakeSpeed = 0;
        }

    }
    
    // used for testing
    public void selfTest() {}

    public void resetState() {
        intakeState = intakeStateEnum.CLOSED; 
    }

    // returns the unique name of the example
    public String getName() {
        return "Scoring";
    }
}