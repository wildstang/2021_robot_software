package org.wildstang.year2021.auto.programs;


import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.PathStep;
/*
 For testing PathStep.
 - set RobotWidth and WheelRadius to reasonable values with correct units in PathStep before running.
 
 Hopefully makes the robot do doughnuts counterclockwise.
 */
public class OtherTestProgram extends AutoProgram {
    double PI = Math.PI;
    @Override
    protected void defineSteps() {

        // define a series of steps
        double[] Xs ={0,0,2,2,4,4,6,6,0};
        double[] Ys = {0,20,20,0,20,20,20,0,0};
        double[] Angles = {0,0.5*PI,1.5*PI,1.5*PI,0.5*PI,0.5*PI,1.5*PI,1.5*PI,0};
        double[] Speeds = {0.6,0.6,0.3,0.6,0.3,0.6,0.3,0.6,0.3};
        addStep(new DelayStep(3));
        PathStep path = new PathStep();
        path.PathStep(Xs,Ys,Angles,Speeds);
        addStep(path);
    }

    @Override
    public String toString() {
        return "Doughnuts";
    }

}
