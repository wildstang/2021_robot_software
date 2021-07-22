package org.wildstang.year2020.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.framework.auto.steps.AutoParallelStepGroup;
import org.wildstang.framework.auto.steps.AutoSerialStepGroup;
import org.wildstang.year2020.auto.steps.AutoAimStep;
import org.wildstang.year2020.auto.steps.DelayStep;
import org.wildstang.year2020.auto.steps.FeedOffStep;
import org.wildstang.year2020.auto.steps.FeedOnStep;
import org.wildstang.year2020.auto.steps.IntakeOnStep;
import org.wildstang.year2020.auto.steps.PathFollowerStep;
import org.wildstang.year2020.auto.steps.SetTurretStep;

public class Steal10 extends AutoProgram{

    @Override
    protected void defineSteps() {
        AutoParallelStepGroup initial = new AutoParallelStepGroup();
        initial.addStep(new IntakeOnStep(true));
        initial.addStep(new PathFollowerStep(PathNameConstants.STEAL10A,true,true));
        initial.addStep(new SetTurretStep(-29400));
        addStep(initial);

        //make this step aim when it's nearly done
        AutoParallelStepGroup second = new AutoParallelStepGroup();
        second.addStep(new PathFollowerStep(PathNameConstants.STEAL10B,true,false));
        AutoSerialStepGroup secondA = new AutoSerialStepGroup();
        secondA.addStep(new DelayStep(1.0));
        secondA.addStep(new AutoAimStep(true));
        second.addStep(secondA);
        addStep(second);

        addStep(new FeedOnStep());
        addStep(new DelayStep(2.0));
        addStep(new FeedOffStep());
        addStep(new AutoAimStep(false));


        AutoParallelStepGroup third = new AutoParallelStepGroup();
        third.addStep(new PathFollowerStep(PathNameConstants.STEAL10C,true,true));
        AutoSerialStepGroup thirdA = new AutoSerialStepGroup();
        thirdA.addStep(new DelayStep(5.0));
        thirdA.addStep(new AutoAimStep(true));
        third.addStep(thirdA);
        addStep(third);

        
        addStep(new FeedOnStep());
    }

    @Override
    public String toString() {
        return "Steal10";
    }
    
}
