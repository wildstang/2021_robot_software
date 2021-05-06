package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.timer.WsTimer;
import org.wildstang.year2021.subsystems.Highball;


/**
 * 
 */
public class HighballDeployStep extends AutoStep {

    private Highball HighArm;

    //public BallpathDeployStep(double delay) {
    //    this.delay = delay;
    //}

    public void initialize() {
        // start the timer
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