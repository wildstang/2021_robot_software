package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DriveBackwardsStep;
import org.wildstang.year2021.auto.steps.DelayStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class RetrieveBlackFuel extends AutoProgram {

    @Override
    protected void defineSteps() {
        // define a series of steps
        addStep(new DriveBackwardsStep());
        addStep(new DelayStep(2));
        addStep(new DriveBackwardsStep(0.0));
    }

    @Override
    public String toString() {
        // give it a name
        return "RetrieveBlackFuel";
    }

}