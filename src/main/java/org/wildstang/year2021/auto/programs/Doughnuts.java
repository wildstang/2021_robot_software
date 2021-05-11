//
package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.PathStep;
/*
 For testing PathStep.
 - set RobotWidth and WheelRadius to reasonable values with correct units in PathStep before running.
 
 Hopefully makes the robot do doughnuts counterclockwise.
 */
public class Doughnuts extends AutoProgram {
    double PI = Math.PI;
    @Override
    protected void defineSteps() {

        // define a series of steps
        double[] Xs ={0,-2,-4,-2,0,-2,-4,-2,0};
        double[] Ys = {0,2,0,-2,0,2,0,-2,0};
        double[] Angles = {0,0.5*PI,PI,1.5*PI,0,0.5*PI,PI,1.5*PI,0};
        double[] Speeds = {0.6,0.6,0.6,0.6,0.6};
        addStep(new DelayStep(3));
        PathStep path = new PathStep(Xs,Ys,Angles,Speeds);
        //path.PathStep(Xs,Ys,Angles,Speeds);
        addStep(path);
    }

    @Override
    public String toString() {
        return "Doughnuts";
    }

}
