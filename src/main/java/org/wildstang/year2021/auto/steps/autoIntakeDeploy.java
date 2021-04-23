package org.wildstang.year2021.auto.steps;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.timer.WsTimer;
import org.wildstang.year2021.subsystems.Scoring;

public class autoIntakeDeploy extends AutoStep {

    WsTimer timer = new WsTimer();
    Scoring intake = new Scoring();
    double delay;

    public void initialize() {
        // start the timer
        timer.start();
        intake.IntakeDeployVictor.set(ControlMode.PercentOutput, 1);
    }

    public void update() {
        // check if the timer has exceded the desired delay
        if (timer.get() > 5 && timer.get() < 10) {
            intake.IntakeDeployVictor.set(ControlMode.PercentOutput, -1);
        }
        else {
            intake.IntakeDeployVictor.set(ControlMode.PercentOutput, 0);
            setFinished(true);
        }
    }

    public String toString() {
        // give it a name
        return "DelayStep";
    }

}