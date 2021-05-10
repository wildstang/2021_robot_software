package org.wildstang.year2021.auto.steps;

import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.subsystems.Ballpath;



/**
 * 
 */
public class HatchOpen extends AutoStep {
    
    private Ballpath Hatch;


    public void initialize() {
        Hatch = (Ballpath) Core.getSubsystemManager().getSubsystem(WSSubsystems.BALLPATH.getName());
        Hatch.turnOnBallpath();
        setFinished(true);
    }

    public void update() {
        // check if the timer has exceded the desired delay
        
    }

    public String toString() {
        // give it a name
        return "HatchOpen";
    }

}