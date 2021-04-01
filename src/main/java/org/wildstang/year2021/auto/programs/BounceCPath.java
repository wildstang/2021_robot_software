package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.PathFollowerStep;

import frc.paths.BounceC;

public class BounceCPath extends AutoProgram{
    @Override
    protected void defineSteps() {
        addStep(new PathFollowerStep(new BounceC().getPath()));
    }

    @Override
    public String toString() {
        //give it a name
        return "Bounce C";
    }
}