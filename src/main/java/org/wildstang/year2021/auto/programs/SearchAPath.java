package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.framework.auto.steps.AutoParallelStepGroup;
import org.wildstang.year2021.auto.steps.PathFollowerStep;
import org.wildstang.year2021.auto.steps.intakeOnStep;

import frc.paths.SearchA;

public class SearchAPath extends AutoProgram{
    @Override
    protected void defineSteps() {
        AutoParallelStepGroup steps = new AutoParallelStepGroup();
        steps.addStep(new PathFollowerStep(new SearchA().getPath()));
        steps.addStep(new intakeOnStep());
        addStep(steps);
    }

    @Override
    public String toString() {
        //give it a name
        return "SearchA";
    }
}