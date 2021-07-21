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

public class Middle8 extends AutoProgram {

    @Override
    protected void defineSteps() {
        addStep(new IntakeOnStep(true));
        addStep(new SetTurretStep(-27000));
        addStep(new PathFollowerStep(PathNameConstants.MIDDLE8A, true, true));

        AutoParallelStepGroup first = new AutoParallelStepGroup();
        first.addStep(new PathFollowerStep(PathNameConstants.MIDDLE8B, true, true));
        AutoSerialStepGroup firstA = new AutoSerialStepGroup();
        firstA.addStep(new DelayStep(1.5));
        firstA.addStep(new AutoAimStep(true));
        first.addStep(firstA);
        addStep(first);

        addStep(new FeedOnStep());
        addStep(new DelayStep(2.0));
        addStep(new FeedOffStep());
        addStep(new PathFollowerStep(PathNameConstants.MIDDLE8C, true, true));
        addStep(new PathFollowerStep(PathNameConstants.MIDDLE8D, true, true));
        addStep(new FeedOnStep());

    }

    @Override
    public String toString() {
        //give it a name
        return "Middle8";
    }

}