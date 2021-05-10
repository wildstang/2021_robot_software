package org.wildstang.year2021.auto.steps;

import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.subsystems.Drive;


/**
 * i need a better name 
 */
public class DriveTurnStep extends AutoStep {
    
    private Drive motors;
    private double speedR;
    private double speedL;

    public DriveTurnStep(double speedR, double speedL) {
        this.speedR = speedR;
        this.speedL = speedL;
    }

    public void initialize() {
        motors = (Drive) Core.getSubsystemManager().getSubsystem(WSSubsystems.DRIVE.getName());
        motors.SetBothSpeeds(speedR, speedL);
        setFinished(true);
    }

    public void update() {
        // check if the timer has exceded the desired delay
    }

    public String toString() {
        // give it a name
        return "DriveTurnStep";
    }

}