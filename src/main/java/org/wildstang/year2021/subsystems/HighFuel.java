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
public class HighFuel implements Subsystem {

    static int OPENTIME = 30;

    public boolean isAuto;

    private DigitalInput clawDeploy; 
    private DigitalInput clawRelease; 
    private VictorSPX clawVictor; 
    private boolean deployed;
    //private WsTimer timer; 


    public void init() {
        clawDeploy = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_FACE_UP.getName());
        clawDeploy.addInputListener(this);
        clawRelease = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_FACE_LEFT.getName());
        clawRelease.addInputListener(this);
        clawVictor = new VictorSPX(CANConstants.HighFuel);
        deployed = false; 
        isAuto = false; 
        //timer.start();
        
    }

    public void update() {
        if(!isAuto) {
            if(clawRelease.getValue()) {
                clawVictor.set(ControlMode.PercentOutput, 1);
            }
            else if (clawDeploy.getValue()) {
                clawVictor.set(ControlMode.PercentOutput, -1);
            }
            else {
                clawVictor.set(ControlMode.PercentOutput, 0);
            }
        }
    }

    public void inputUpdate(Input signal) {
        
    }

    public void selfTest() {

    }

    public void openClaw(double speed) {
        clawVictor.set(ControlMode.PercentOutput, speed);
    }

    public void resetState() {
       deployed = false; 
       
    }

    public String getName() {
        return "High Fuel";
    }
}