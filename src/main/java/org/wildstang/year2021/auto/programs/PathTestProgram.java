package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.PathStep;
/*
 For testing PathStep.
 - set RobotWidth and WheelRadius to reasonable values with correct units in PathStep before running.
 
 Hopefully makes the robot move through some points, ending about two units right, two units down relitive to its starting point. Ideally, it ends with about the same orientation.
 Should be really slow.
 */
public class PathTestProgram extends AutoProgram {
    double PI = Math.PI;
    @Override
    protected void defineSteps() {

        // define a series of steps
        double[] Xs ={0,2,2,0,-2};
        double[] Ys = {0,0,2,0,-2};
        double[] DyDxs = {0,0,PI/2,(5/4)*PI,0};
        double[] Speeds = {0.1,0.1,0.1,0.1,0.1};
        addStep(new DelayStep(5));
        PathStep path = new PathStep(Xs,Ys,DyDxs,Speeds);
        //path.PathStep(Xs,Ys,DyDxs,Speeds);
        addStep(path);
    }

    @Override
    public String toString() {
        return "PathTestProgram";
    }

}
