package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.year2021.subsystems.drive.TankDrive;

public class DriveRightBackwardsStep extends AutoStep {
    TankDrive drive = new TankDrive();
    double speed = 0.0;

    public DriveRightBackwardsStep() {
        this(-1.0);
    }
    
    public DriveRightBackwardsStep(double s) {
        if (s <= 1.0 || s >= -1.0) {
            speed = -Math.abs(s);
        }  
        else {
            speed = 0.0;
        }
    }

    public void initialize() {
        drive.setRightMotorSpeed(speed);
    }

    public void update() {
        setFinished(true);
    }
    
    public String toString() {
        return "DriveRightBackwardsStep";
    }
}
