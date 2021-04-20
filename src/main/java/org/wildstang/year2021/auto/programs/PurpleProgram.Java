package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.RunIntakeStep;
import org.wildstang.year2021.auto.steps.DriveForwardsStep;
import org.wildstang.year2021.auto.steps.ArmUpwardsStep;
import org.wildstang.year2021.auto.steps.ArmDownwardsStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class PurpleProgram extends AutoProgram {

    @Override
    protected void defineSteps() {
        //Starts the roller and drives towards the center
        addStep(new DriveForwardsStep());
        addStep(new RunIntakeStep());
        addStep(new DelayStep(3));
        //Stops moving forward and raises arm
        addStep(new DriveForwardsStep(0));
        addStep(new ArmUpwardsStep());
        addStep(new DelayStep(1));
        //Moves arm downward
        addStep(new ArmDownwardsStep());
        addStep(new DelayStep(1));
        //Stops arm moving downward and stops the intake
        addStep(new ArmDownwardsStep(0));
        addStep(new RunIntakeStep(0));
    }

    @Override
    public String toString() {
        return "PurpleProgram";
    }

}