package org.wildstang.year2021.auto.steps;

import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.subsystems.Ballpath;
import org.wildstang.framework.timer.WsTimer;


/**
 * 
 */
public class IntakeDeployStep extends AutoStep {

    private Ballpath Elevator;
    WsTimer timer = new WsTimer();
    double openTime = 1;

    //public BallpathDeployStep(double delay) {
    //    this.delay = delay;
    //}

    public void initialize() {
        Elevator = (Ballpath) Core.getSubsystemManager().getSubsystem(WSSubsystems.BALLPATH.getName());
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
        return "IntakeDeployStep";
    }

}