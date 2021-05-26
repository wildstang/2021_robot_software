package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.PathFollowerStep;
import org.wildstang.year2021.auto.steps.PathHeadingStep;

import frc.paths.Slalom;

public class TestPath extends AutoProgram{
    @Override
    protected void defineSteps() {
        addStep(new PathHeadingStep(0));
        addStep(new PathFollowerStep(new Slalom().getPath()));
    }

    @Override
    public String toString() {
        //give it a name
        return "Test";
    }
}
