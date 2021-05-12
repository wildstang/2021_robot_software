package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.year2021.subsystems.hopper.Hopper;

public class RunHopperStep extends AutoStep {
    private Hopper hopper;
    private double speed = 0.0;

    public RunHopperStep() {
        this(1.0);
    }

    public RunHopperStep(double i) {
        hopper = (Hopper) Core.getSubsystemManager().getSubsystem(WSSubsystems.HOPPER.getName());
        if (i <= 1.0 || i >= -1.0){
            speed = i;
        } else {
            speed = 0.0;
        }
    }

    public void initialize() {
        hopper.setHopperSpeed(speed);
    }

    public void update() {
        setFinished(true);
    }
    
    public String toString() {
        return "RunHopperStep";
    }
}
