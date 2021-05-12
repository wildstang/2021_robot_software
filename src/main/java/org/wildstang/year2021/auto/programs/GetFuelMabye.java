package org.wildstang.year2021.auto.programs;


//
import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.PathStep;
import org.wildstang.year2021.auto.steps.HighballDeployStep;
import org.wildstang.year2021.auto.steps.IntakeDeployStep;
import org.wildstang.year2021.auto.steps.IntakeOnStep;
import org.wildstang.year2021.auto.steps.IntakeOffStep;

public class GetFuelMabye extends AutoProgram {
    double PI = Math.PI;

    @Override
    protected void defineSteps() {

        // define a series of steps
        double[] Xs ={0,3,3,3};
        double[] Ys = {0,0,7,7};
        double[] Angles = {0,PI/2,PI/2,0.75*PI};
        double[] Speeds = {1,1,1,0.25};
        addStep(new DelayStep(5));
        PathStep path = new PathStep(Xs,Ys,Angles,Speeds);
        //path.PathStep(Xs,Ys,DyDxs,Speeds);
        addStep(new HighballDeployStep());
        addStep(new IntakeDeployStep());
        addStep(path);
        addStep(new IntakeOnStep());
        addStep(new DelayStep(1));
        addStep(new IntakeOffStep());
        double[] Xs2 ={3,3,3,3};
        double[] Ys2 = {7,0,-7,-7};
        double[] Angles2 = {0.75*PI,1.5*PI,1.5*PI,1.25*PI};
        double[] Speeds2 = {1,-1,1,0.25};
        PathStep path2 = new PathStep(Xs2,Ys2,Angles2,Speeds2);
        addStep(path2);
        addStep(new IntakeOnStep());
        addStep(new DelayStep(1));
        addStep(new IntakeOffStep());
        double[] Xs3 ={3,0};
        double[] Ys3 = {-7,0};
        double[] Angles3 = {1.25*PI,0};
        double[] Speeds3 = {0.25,-1};
        PathStep Return = new PathStep(Xs3,Ys3,Angles3,Speeds3);
        addStep(Return);

    }

    @Override
    public String toString() {
        return "GetFuelMabye";
    }
}
