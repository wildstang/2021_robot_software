package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.year2021.subsystems.arm.Arm;

public class ArmUpwardsStep extends AutoStep {
    private Arm arm;
    private double speed = 0.0;

    public ArmUpwardsStep() {
        this(1.0);
    }

    public ArmUpwardsStep(double s) {
        arm = (Arm) Core.getSubsystemManager().getSubsystem(WSSubsystems.ARM.getName());
        if (speed >= -1 && speed <= 1) {
            speed = Math.abs(s);
        } else {
            speed = 0;
        }
    }

    public void initialize() {
        arm.setArmSpeed(speed);
    }

    public void update() {
        setFinished(true);
    }

    public String toString() {
        return "ArmUpwardsStep";
    }
}