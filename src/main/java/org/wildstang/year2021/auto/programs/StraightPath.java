package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.framework.auto.steps.AutoParallelStepGroup;
import org.wildstang.year2021.auto.steps.PathFollowerStep;
import org.wildstang.year2021.auto.steps.intakeOnStep;

import frc.paths.Straight;

public class StraightPath extends AutoProgram{
    @Override
    protected void defineSteps() {
        //AutoParallelStepGroup steps = new AutoParallelStepGroup();
        addStep(new intakeOnStep());
        addStep(new PathFollowerStep(new Straight().getPath()));
        //addStep(steps);
    }

    @Override
    public String toString() {
        //give it a name
        return "Straight";
    }
}