package org.wildstang.year2020.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.framework.auto.steps.AutoParallelStepGroup;
import org.wildstang.framework.auto.steps.AutoSerialStepGroup;
import org.wildstang.year2020.auto.steps.FeedOffStep;
import org.wildstang.year2020.auto.steps.FeedOnStep;
import org.wildstang.year2020.auto.steps.PathFollowerStep;
import org.wildstang.year2020.auto.steps.SetTurretStep;
import org.wildstang.year2020.auto.steps.AutoAimStep;
import org.wildstang.year2020.auto.steps.DelayStep;
import org.wildstang.year2020.auto.steps.IntakeOnStep;
import org.wildstang.year2020.auto.programs.PathNameConstants;

public class Trench6 extends AutoProgram {

    @Override
    protected void defineSteps() {
        AutoParallelStepGroup initial = new AutoParallelStepGroup();
        initial.addStep(new IntakeOnStep(true));
        initial.addStep(new SetTurretStep(-29400));
        initial.addStep(new DelayStep(3.0));
        addStep(initial);
        addStep(new AutoAimStep(true));
        addStep(new DelayStep(2));

        addStep(new FeedOnStep());
        addStep(new DelayStep(2.0));
        addStep(new FeedOffStep());

        addStep(new PathFollowerStep(PathNameConstants.TRENCH8C, true, true));

        addStep(new PathFollowerStep(PathNameConstants.TRENCH8D,true,false));
        
        addStep(new FeedOnStep());
    }

    @Override
    public String toString() {
        //give it a name
        return "Trench6";
    }

}