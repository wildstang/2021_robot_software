package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DriveForwardsStep;
import org.wildstang.year2021.auto.steps.DriveLeftForwardsStep;
import org.wildstang.year2021.auto.steps.DriveRightForwardsStep;
import org.wildstang.year2021.auto.steps.RunIntakeStep;
import org.wildstang.year2021.auto.steps.DelayStep;

public class CollectLeftEdge extends AutoProgram{

    @Override
    protected void defineSteps() {
        //align with edge of field
        addStep(new DriveRightForwardsStep(1.0));
        addStep(new DelayStep(0.75));
        addStep(new DriveRightForwardsStep(0.0));
        addStep(new DelayStep(0.5));
        addStep(new DriveForwardsStep(0.5));
        addStep(new DelayStep(0.5));
        addStep(new DriveForwardsStep(0.0));
        addStep(new DelayStep(0.5));
        addStep(new DriveLeftForwardsStep(1.0));
        addStep(new DelayStep(0.50));
        addStep(new DriveLeftForwardsStep(0.0));
        addStep(new DelayStep(0.5));
        //prepare to collect fuel
        addStep(new RunIntakeStep(1.0));
        addStep(new DelayStep(0.5));
        //collect fuel
        addStep(new DriveForwardsStep(1.0));
        addStep(new DelayStep(3));
        addStep(new DriveForwardsStep(0.0));
        //disengage intake
        addStep(new RunIntakeStep(0.0));
    }

    @Override
    public String toString() {
        return "CollectLeftEdge";
    }
}
