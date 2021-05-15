
//
package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.PathStep;
import org.wildstang.year2021.auto.steps.HighballDeployStep;
/*
 For testing PathStep.
 - set RobotWidth and WheelRadius to reasonable values with correct units in PathStep before running.
 
 Hopefully makes the robot move 4 feet forward. For tuning MaxSpeed value in PathStep
 Should be really slow.
 */
public class FourFeet extends AutoProgram {
    double PI = Math.PI;
    @Override
    protected void defineSteps() {

        // define a series of steps
        double[] Xs ={0,4,4};
        double[] Ys = {0,0,0};
        double[] DyDxs = {0,0,0};
        double[] Speeds = {0.0005,0.0005,0};
        //addStep(new DelayStep(3));
        PathStep path = new PathStep(Xs,Ys,DyDxs,Speeds);
        //path.PathStep(Xs,Ys,DyDxs,Speeds);
        addStep(path);
        addStep(new HighballDeployStep());
    }

    @Override
    public String toString() {
        return "FourFeet";
    }

}
