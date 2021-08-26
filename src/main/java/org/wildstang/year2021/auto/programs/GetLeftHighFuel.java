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
import org.wildstang.year2021.auto.steps.HighballStay;

public class GetLeftHighFuel extends AutoProgram {
    double PI = Math.PI;

    @Override
    protected void defineSteps() {

        // define a series of steps
        double[] Xs ={0, //start at 0 (centered)
        -2,-8.5948,-8.5, //go to left high fuel
        -8.5,0,0}; //return to starting position to dump fuel
        double[] Ys = {1,//start 1ft away from edge of scoreing box  //go get center fuels, be 1ft away from center
        -0.8,-1.27,-1.2,
        1.5,1,1}; 
        double[] Angles = {PI,
        (5.0*PI/4.0),(1.0/4.0)*PI,(1.0/2.0)*PI, //wiggle a bit to knock high fuel down
        (1.0/2.0)*PI,PI/2.0,PI/2.0}; 
        double[] Speeds = {0.2,
        0.2,-0.2,-0.2,
        0.2,-0.2,-0.2}; //go backwards back to base
        PathStep Path = new PathStep(Xs,Ys,Angles,Speeds);
        //path.PathStep(Xs,Ys,DyDxs,Speeds);
        addStep(new IntakeDeployStep());
        addStep(new HighballDeployStep());
        addStep(new DelayStep(2));
        addStep(new HighballStay());
        addStep(new IntakeOnStep());
        addStep(Path);
        addStep(new IntakeOffStep());
        addStep(new HatchOpen());
        addStep(new DelayStep(3));
        addStep(new HatchClose());
        

    }

    @Override
    public String toString() {
        return "GetLeftHighFuel";
    }
}

