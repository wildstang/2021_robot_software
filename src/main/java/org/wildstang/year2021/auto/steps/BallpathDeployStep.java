package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.timer.WsTimer;
import org.wildstang.year2021.subsystems.Ballpath;


/**
 * 
 */
public class BallpathDeployStep extends AutoStep {

    private Ballpath Elevator;
    WsTimer timer = new WsTimer();
    double openTime = 10;

    //public BallpathDeployStep(double delay) {
    //    this.delay = delay;
    //}

    public void initialize() {
        // start the timer
        timer.start();
        Elevator.ballpathDeploy();
    }

    public void update() {
        // check if the timer has exceded the desired delay
        if (timer.get() >= openTime) {
            Elevator.turnOffBallpath();
            setFinished(true);
        }
    }

    public String toString() {
        // give it a name
        return "BallpathDeployStep";
    }

}