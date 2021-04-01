package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.PathFollowerStep;

import frc.paths.BounceA;
import frc.paths.BounceB;
import frc.paths.BounceC;
import frc.paths.BounceD;

public class BouncePath extends AutoProgram{
    @Override
    protected void defineSteps() {
        addStep(new PathFollowerStep(new BounceA().getPath()));
        addStep(new PathFollowerStep(new BounceB().getPath()));
        addStep(new PathFollowerStep(new BounceC().getPath()));
        addStep(new PathFollowerStep(new BounceD().getPath()));
    }

    @Override
    public String toString() {
        //give it a name
        return "Bounce All";
    }
}
