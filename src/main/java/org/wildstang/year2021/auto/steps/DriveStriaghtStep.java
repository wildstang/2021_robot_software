package org.wildstang.year2021.auto.steps;

import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.subsystems.Drive;


/**
 *  
 */
public class DriveStriaghtStep extends AutoStep {
    
    private Drive motors;
    private double speed;

    public DriveStriaghtStep(double speed) {
        this.speed = speed;
    }

    public void initialize() {
        motors = (Drive) Core.getSubsystemManager().getSubsystem(WSSubsystems.DRIVE.getName());

        motors.SetBothSpeeds(speed, speed);
        setFinished(true);
    }

    public void update() {
        // check if the timer has exceded the desired delay
    }

    public String toString() {
        // give it a name
        return "DriveStriaghtStep";
    }

}