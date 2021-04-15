package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.StopStep;
import org.wildstang.year2021.auto.steps.DriveForwardStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class ForwardProgram extends AutoProgram {

    @Override
    protected void defineSteps() {
        // define a series of step
        addStep (new DriveForwardStep(2));
        addStep(new StopStep());
    }

    @Override
    public String toString() {
        // give it a name
        return "Forward Program";
    }

}