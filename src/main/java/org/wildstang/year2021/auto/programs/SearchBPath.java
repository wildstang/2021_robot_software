package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.PathFollowerStep;

import frc.paths.SearchB;

public class SearchBPath extends AutoProgram{
    @Override
    protected void defineSteps() {
        addStep(new PathFollowerStep(new SearchB().getPath()));
    }

    @Override
    public String toString() {
        //give it a name
        return "SearchB";
    }
}