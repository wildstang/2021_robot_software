//
package org.wildstang.year2021.auto.programs;
//
import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.IntakeDeployStep;
import org.wildstang.year2021.auto.steps.IntakeOnStep;
import org.wildstang.year2021.auto.steps.IntakeOffStep;
import org.wildstang.year2021.auto.steps.HighballDeployStep;
import org.wildstang.year2021.auto.steps.DriveStriaghtStep;
import org.wildstang.year2021.auto.steps.DriveStopStep;
import org.wildstang.year2021.auto.steps.DriveTurnStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class AutoPath1 extends AutoProgram {

    @Override
    protected void defineSteps() {
        // define a series of steps
        //addStep(new HighballDeployStep());

        //addStep(new DriveStriaghtStep(0.75));
        //addStep(new DelayStep(1));
        //addStep(new DriveStopStep());

        //addStep(new DriveTurnStep(-.25, .25)); //180 (high ball)
        //addStep(new DelayStep(1));
        //addStep(new DriveStopStep());
        
        //addStep(new DriveStriaghtStep(0.75));
        //addStep(new DelayStep(1));
        //addStep(new DriveStopStep());

        addStep(new IntakeDeployStep());
        addStep(new DelayStep(1));
        addStep(new IntakeOffStep());
        
        //turn pivot
        //addStep(new IntakeOnStep());
        //addStep(new DriveTurnStep(.25, .25));
        //addStep(new DelayStep(1.5));
        //addStep(new DriveStopStep());
        //addStep(new IntakeOffStep());
    }

    @Override
    public String toString() {
        // give it a name
        return "AutoPath1";
    }

}