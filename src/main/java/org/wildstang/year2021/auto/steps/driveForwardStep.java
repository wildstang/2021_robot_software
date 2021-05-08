package org.wildstang.year2021.auto.steps;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.wildstang.devbase1.robot.WSSubsystems;
import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.framework.timer.WsTimer;
import org.wildstang.year2019.auto.programs.Left2056L1;
import org.wildstang.year2021.subsystems.Scoring;
import org.wildstang.year2021.subsystems.Drive;

public class driveForwardStep extends AutoStep {

    WsTimer timer = new WsTimer();
    public Drive drive;
    
    double speed, acc, dec, time;
    double leftSpeed = 0;
    double rightSpeed = 0;

    /*
    speed = max speed of the robot from 0 / 1
    acc = number of ticks to reach max speed 0 / infinite
    dec = number of ticks to decelerate 0 / (time - acc)
    */
    
    public driveForwardStep(double s, double a, double d, double t) {
        this.speed = s;
        this.acc = a;
        this.dec = d;
        this.time = t;
    }

    public void initialize() {
        timer.start();
        leftSpeed = 0; 
        rightSpeed = 0;
        drive = (Drive) Core.getSubsystemManager().getSubsystem(org.wildstang.year2021.robot.WSSubsystems.DRIVE.getName());
        drive.isAuto = true;
        System.out.println("drive start");
    }

    public void update() {
        
        if (timer.get() < acc) {
            leftSpeed += (speed/acc) / 100;
            rightSpeed += (speed/acc) / 100;
        }

        if (timer.get() > (time - dec)) {
            leftSpeed -= (speed/dec) / 100;
            rightSpeed -= (speed/dec) / 100;
        }
        
        drive.setSpeed(leftSpeed, rightSpeed);

        if (timer.get() > time) {
            drive.setSpeed(leftSpeed, rightSpeed);
            drive.isAuto = false;
            setFinished(true);
        }
        
    }

    public String toString() {
        return "DelayStep";
    }
}