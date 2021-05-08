package org.wildstang.year2021.auto.steps;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.wildstang.devbase1.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.framework.timer.WsTimer;
import org.wildstang.year2019.auto.programs.Left2056L1;
import org.wildstang.year2021.subsystems.Scoring;
import org.wildstang.year2021.subsystems.Drive;
import org.wildstang.year2021.subsystems.HighFuel;

public class clawDeployStep extends AutoStep {
    
    WsTimer timer = new WsTimer(); 
    public HighFuel highFuel;
    boolean isOpening;

    public clawDeployStep(boolean opening) {
        isOpening = opening;  
    }

    public void initialize() {
        highFuel = (HighFuel) Core.getSubsystemManager().getSubsystem(org.wildstang.year2021.robot.WSSubsystems.HIGH_FUEL.getName());
        highFuel.isAuto = true;
        timer.start();
    }

    public void update() {
        if (isOpening) {
            highFuel.openClaw(-1);
            if (timer.get() > 0.5) {
                highFuel.openClaw(0);
                setFinished(true);
            }
        }
        else {
            highFuel.openClaw(1);
            if (timer.get() > 0.5) {
                highFuel.openClaw(0);
                setFinished(true);
            }
        }
    }

    public String toString() {
        return "clawDeployStep";
    }

}