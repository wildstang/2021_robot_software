package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.PathFollowerStep;

import frc.paths.BounceB;

public class BounceBPath extends AutoProgram{
    @Override
    protected void defineSteps() {
        addStep(new PathFollowerStep(new BounceB().getPath()));
    }

    @Override
    public String toString() {
        //give it a name
        return "Bounce B";
    }
}