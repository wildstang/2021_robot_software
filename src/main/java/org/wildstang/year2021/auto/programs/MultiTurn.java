package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.PathFollowerStep;
import org.wildstang.year2021.auto.steps.PathHeadingStep;

import frc.paths.Turn;
import frc.paths.TurnB;
import frc.paths.TurnC;
import frc.paths.TurnD;

public class MultiTurn extends AutoProgram{
    @Override
    protected void defineSteps() {
        addStep(new PathHeadingStep(90));
        addStep(new PathFollowerStep(new Turn().getPath()));
        addStep(new PathHeadingStep(180));
        addStep(new PathFollowerStep(new TurnB().getPath()));
        addStep(new PathHeadingStep(270));
        addStep(new PathFollowerStep(new TurnC().getPath()));
        addStep(new PathHeadingStep(0));
        addStep(new PathFollowerStep(new TurnD().getPath()));
    }

    @Override
    public String toString() {
        //give it a name
        return "Turn";
    }
}