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
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.framework.timer.WsTimer;
import org.wildstang.year2019.auto.steps.DeployHatch;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;

import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       TestSubsystem.java
 * Inputs:      1 joystick
 * Outputs:     1 talon
 * Description: This is a testing subsystem that controls a single motor with a joystick.
 */
public class Descoring implements Subsystem {

    private AnalogInput controlStick;
    private VictorSPX descoringMotor;
    private double speed;

    public void init() {   
        controlStick = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_RIGHT_JOYSTICK_X.getName());
        controlStick.addInputListener(this);
        speed = 0; 
        descoringMotor = new VictorSPX(CANConstants.Descoring);
        
    }

    public void update() {
        if(speed > 0.1 || speed < -0.1) descoringMotor.set(ControlMode.PercentOutput, speed);
        else descoringMotor.set(ControlMode.PercentOutput, 0);
    }

    public void inputUpdate(Input signal) {
        speed = controlStick.getValue();
    }

    public void selfTest() {

    }

    public void resetState() {
       speed = 0; 
       descoringMotor.set(ControlMode.PercentOutput, 0);
    }

    public String getName() {
        return "Descoring";
    }
}