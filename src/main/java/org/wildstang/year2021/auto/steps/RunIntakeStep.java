package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.year2021.subsystems.intake.Intake;

public class RunIntakeStep extends AutoStep{
    Intake intake = new Intake();
    double speed = 0.0;

    public RunIntakeStep(){
        this(1.0);
    }

    public RunIntakeStep(double i){
        if (i <= 1.0 || i >= -1.0){
            speed = i;
        } else {
            speed = 0.0;
        }
    }

    public void initialize() {
        intake.setIntakeSpeed(speed);
    }

    public void update() {
        setFinished(true);
    }
    
    public String toString() {
        return "RunIntakeStep";
    }
}
