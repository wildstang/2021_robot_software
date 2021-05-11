package org.wildstang.year2021.auto.programs;


//
import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.PathStep;


public class GetFuelMabye extends AutoProgram {
    double PI = Math.PI;

    @Override
    protected void defineSteps() {

        // define a series of steps
        double[] Xs ={0,1,1};
        double[] Ys = {0,0,3};
        double[] DyDxs = {0,PI/2,PI/2};
        double[] Speeds = {1,1,1};
        addStep(new DelayStep(5));
        PathStep path = new PathStep(Xs,Ys,DyDxs,Speeds);
        //path.PathStep(Xs,Ys,DyDxs,Speeds);
        addStep(path);
        //deploy high fuel here
        addStep(new DelayStep(1));
        //un-deploy highfuel
        double[] Xs2 ={1,1,1,0};
        double[] Ys2 = {3,0,-3,0};
        double[] DyDxs2 = {0,1.5*PI,1.5*PI,0};
        double[] Speeds2 = {1,-1,1,-1};
        addStep(new DelayStep(5));
        PathStep path2 = new PathStep(Xs2,Ys2,DyDxs2,Speeds2);
        addStep(path2);

    }

    @Override
    public String toString() {
        return "GetFuelMabyeProgram";
    }
}
