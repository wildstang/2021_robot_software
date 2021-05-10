package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.year2021.subsystems.drive.TankDrive;

public class DriveLeftBackwardsStep extends AutoStep {
    private TankDrive drive;
    private double speed = 0.0;

    public DriveLeftBackwardsStep() {
        this(-1.0);
    }
    
    public DriveLeftBackwardsStep(double s) {
        drive = (TankDrive) Core.getSubsystemManager().getSubsystem(WSSubsystems.TANKDRIVE.getName());
        if (s <= 1.0 || s >= -1.0) {
            speed = -Math.abs(s);
        }  
        else {
            speed = 0.0;
        }
    }

    public void initialize() {
        drive.setLeftMotorSpeed(speed);
    }

    public void update() {
        setFinished(true);
    }
    
    public String toString() {
        return "DriveLeftBackwardsStep";
    }
}
