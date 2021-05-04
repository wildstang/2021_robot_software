package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.PathStep;
/*
 For testing PathStep.
 - set RobotWidth and MaxSpeed to reasonable values with correct units in PathStep before running. SpeedConstant may be too low right now.
 
 Hopefully makes the robot move through some points, ending about two units right, two units down relitive to its starting point. Ideally, it ends with about the same orientation.
 */
public class ExampleAutoProgram extends AutoProgram {

    @Override
    protected void defineSteps() {
        // define a series of steps
        addStep(new DelayStep(5));
        addStep(new PathStep(new double[]{0,2,2,0,-2},new double[]{0,0,2,0,-2},new double[]{0,0,999,-1,0}));
    }

    @Override
    public String toString() {
        return "PathTestProgram";
    }

}
