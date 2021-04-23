package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.core.Core;
import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.year2021.subsystems.Lift;


/**
 * This is an example Autonomous Step.
 * Autonomous steps define a single repeatable operation we want to perform in autonomous programs.
 * These programs are started by calling "initialize", then "update" is repeatedly called, until "setFinished(true)" is called.
 * The "toString" function defines a name for the step.
 *
 * In this example an AutoStep is created for an amount of time in seconds called "delay".
 * When the step is initialized a timer is started.
 * When the step is updated, the time is checked. If the time excedes the delay, the step if set to finished.
 */
public class deployLiftStep extends AutoStep {
    private Lift lift;
    public void initialize(){
        lift = (Lift) Core.getSubsystemManager().getSubsystem(WSSubsystems.LIFT.getName());
    }

    public void update(){
        lift.deployLift();
        this.setFinished(true);
    }
    

    public String toString() {
        // give it a name
        return "Deploy Lift";
    }

}