package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
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
        INTAKE (1),
        OUTPUT (-1),
        OFF (0);

        private final double Speed; 

        intakeStateEnum(double speed) {
            this.Speed = speed;
        }
        
        public double speed() {
            return Speed;
        }
    }

    private intakeStateEnum intakeState; 
    private double deploySpeed; 
    private double deployStickValue;

    private DigitalInput deployButtonDown;
    private DigitalInput intakeButton;
    private DigitalInput outputButton; 

    private AnalogInput deployStick; 

    //motors
    public VictorSPX IntakeVictor; //intake = positive, output = negative 
    public VictorSPX IntakeDeployVictor;  //up = negative, down = positve





    // initializes the subsystem
    public void init() {
        intakeButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_FACE_RIGHT.getName());
        intakeButton.addInputListener(this);
        outputButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_FACE_DOWN.getName());
        outputButton.addInputListener(this);
        deployStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_LEFT_JOYSTICK_Y.getName());
        deployStick.addInputListener(this);
        IntakeVictor = new VictorSPX(CANConstants.Intake);
        IntakeDeployVictor = new VictorSPX(CANConstants.IntakeDeplay);
        IntakeDeployVictor.setInverted(true);
        intakeState = intakeStateEnum.OFF;
        deploySpeed = 0; 
        
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        IntakeVictor.set(ControlMode.PercentOutput, intakeState.speed());
        IntakeDeployVictor.set(ControlMode.PercentOutput, deploySpeed);
    }

    // respond to input updates     
    public void inputUpdate(Input signal) {
        deployStickValue = deployStick.getValue();
        if(intakeButton.getValue()) intakeState = intakeStateEnum.INTAKE;
        else if(outputButton.getValue()) intakeState = intakeStateEnum.OUTPUT;
        else intakeState = intakeStateEnum.OFF;

        if (deployStickValue > 0.1 || deployStickValue < -0.1) deploySpeed = deployStickValue/1.5;
        else deploySpeed = 0; 
    }

    // used for testing
    public void selfTest() {}

    public void resetState() {
        intakeState = intakeStateEnum.OFF;
        deployStickValue = 0;
        deploySpeed = 0;
    }

    // returns the unique name of the example
    public String getName() {
        return "Scoring";
    }
}