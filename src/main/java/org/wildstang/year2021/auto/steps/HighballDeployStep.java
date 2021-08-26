package org.wildstang.year2021.auto.steps;

import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.subsystems.Highball;


/**
 * 
 */
public class HighballDeployStep extends AutoStep {

    private Highball HighArm;

    public void initialize() {
        HighArm = (Highball) Core.getSubsystemManager().getSubsystem(WSSubsystems.HIGHBALL.getName());

        HighArm.raiseArm();
    }

    public void update() {
        // check if the timer has exceded the desired delay
        setFinished(true);
        
    }

    public String toString() {
        // give it a name
        return "HighballDeployStep";
    }

}