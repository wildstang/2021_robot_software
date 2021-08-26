//
package org.wildstang.year2021.auto.programs;
//
import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.IntakeDeployStep;
import org.wildstang.year2021.auto.steps.IntakeOnStep;
import org.wildstang.year2021.auto.steps.IntakeOffStep;
import org.wildstang.year2021.auto.steps.HighballDeployStep;
import org.wildstang.year2021.auto.steps.HighballStay;
import org.wildstang.year2021.auto.steps.DriveStriaghtStep;
import org.wildstang.year2021.auto.steps.DriveStopStep;
import org.wildstang.year2021.auto.steps.DriveTurnStep;
import org.wildstang.year2021.auto.steps.HatchOpen;
import org.wildstang.year2021.auto.steps.HatchClose;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class Deploys extends AutoProgram {

    @Override
    protected void defineSteps() {
        // define a series of steps
        addStep(new IntakeDeployStep());
        addStep(new HighballDeployStep());
        addStep(new DelayStep(.5));
        addStep(new HighballStay());
        
        addStep(new DriveStriaghtStep(0.5));
        addStep(new DelayStep(1.325));
        addStep(new DriveStopStep());
        
        addStep(new DelayStep(0.25));
        addStep(new DriveTurnStep(-.4, .425));
        addStep(new DelayStep(1.85));
        addStep(new DriveStopStep());

        addStep(new DelayStep(0.25));
        addStep(new DriveTurnStep(.4, -.425));
        addStep(new DelayStep(1.85));
        addStep(new DriveStopStep());

        
        //addStep(new IntakeOnStep());
        //addStep(Path);
        //addStep(new IntakeOffStep());
        //addStep(new HatchOpen());
        //addStep(new DelayStep(3));
        //addStep(new HatchClose());

        //addStep(new DriveStriaghtStep(0.5));
        //addStep(new DelayStep(1.25));
        //addStep(new DriveStopStep());
        //turn normal
       // addStep(new IntakeOnStep());
       // addStep(new DriveTurnStep(.25, -.5));
       // addStep(new DelayStep(1.25));
       // addStep(new DriveStopStep());

      //  addStep(new DriveStriaghtStep(0.5));
      //  addStep(new DelayStep(1.25));
      //  addStep(new DriveStopStep());
      //  addStep(new DelayStep(0.5));

        //turn pivot
      //  addStep(new IntakeOnStep());
     //   addStep(new DriveTurnStep(.25, .25));
      //  addStep(new DelayStep(1.5));
      //  addStep(new DriveStopStep());
      //  addStep(new IntakeOffStep());
    }

    @Override
    public String toString() {
        // give it a name
        return "Deploys";
    }

}