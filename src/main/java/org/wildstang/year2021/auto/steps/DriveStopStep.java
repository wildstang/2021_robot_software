package org.wildstang.year2021.auto.steps;

import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.subsystems.Drive;


/**
 * 
 */
public class DriveStopStep extends AutoStep {
    
    private Drive motors;

    public void initialize() {
        motors = (Drive) Core.getSubsystemManager().getSubsystem(WSSubsystems.DRIVE.getName());
        motors.SetBothSpeeds(0.0, 0.0);
        setFinished(true);
    }

    public void update() {
        // check if the timer has exceded the desired delay
    }

    public String toString() {
        // give it a name
        return "DriveStopStep";
    }

}