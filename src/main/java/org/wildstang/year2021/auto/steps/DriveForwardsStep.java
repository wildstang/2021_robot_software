package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.year2021.subsystems.drive.TankDrive;

public class DriveForwardsStep extends AutoStep {
    TankDrive drive = new TankDrive();
    double speed = 0.0;

    public DriveForwardsStep() {
        this(1.0);
    }
    
    public DriveForwardsStep(double s) {
        if (s <= 1.0 || s >= -1.0) {
            speed = Math.abs(s);
        }  
        else {
            speed = 0.0;
        }
    }

    public void initialize() {
        drive.setLeftMotorSpeed(speed);
        drive.setRightMotorSpeed(speed);
    }

    public void update() {
        setFinished(true);
    }
    
    public String toString() {
        return "DriveForwardsStep";
    }
}
