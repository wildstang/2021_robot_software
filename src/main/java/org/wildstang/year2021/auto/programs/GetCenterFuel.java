package org.wildstang.year2021.auto.programs;


//
import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.PathStep;
import org.wildstang.year2021.auto.steps.HighballDeployStep;
import org.wildstang.year2021.auto.steps.IntakeDeployStep;
import org.wildstang.year2021.auto.steps.IntakeOnStep;
import org.wildstang.year2021.auto.steps.IntakeOffStep;
import org.wildstang.year2021.auto.steps.HatchOpen;
import org.wildstang.year2021.auto.steps.HatchClose;

public class GetCenterFuel extends AutoProgram {
    double PI = Math.PI;

    @Override
    protected void defineSteps() {

        // define a series of steps
        double[] Xs ={0, //start at 0 (centered)
        0,
        -2,-8.5948,-8.5, //go to left high fuel
        -8.5,0,2,8.5948,8.5, //Back out, then go to right high fuel
        6.5,0}; //return to starting position to dump fuel
        double[] Ys = {1,//start 1ft away from edge of scoreing box
        6.918, //go get center fuels, be 1ft away from center
        6.918,-1.27,-1.2,
        0,6.918,6.918,-1.27,-1.2,
        0.8,1}; 
        double[] Angles = {PI/2.0,
        PI, //be driving left relitive to driver station when getting fuel from center
        PI,(5.0/4.0)*PI,(3.0/2.0)*PI, //wiggle a bit to knock high fuel down
        (3.0/2.0)*PI,0,0,(7.0/4.0)*PI,(3.0/2.0)*PI,
        (7.0/4.0)*PI,PI/2.0}; 
        double[] Speeds = {1,
        0.7,
        0.7,0.9,-0.1,
        -0.9,0.7,0.7,0.9,-0.1,
        -0.9,-0.8};
        PathStep Path = new PathStep(Xs,Ys,Angles,Speeds);
        //path.PathStep(Xs,Ys,DyDxs,Speeds);
        //addStep(new DelayStep(1));
        addStep(new IntakeDeployStep());
        addStep(new HighballDeployStep());
        addStep(new IntakeOnStep());
        addStep(Path);
        addStep(new IntakeOffStep());
        addStep(new HatchOpen());
        addStep(new DelayStep(3));
        addStep(new HatchClose());
        

    }

    @Override
    public String toString() {
        return "GetCenterFuel";
    }
}
