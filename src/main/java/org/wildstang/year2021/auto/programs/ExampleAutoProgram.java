package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.autoIntakeDeploy;
import org.wildstang.year2021.auto.steps.driveForwardStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class ExampleAutoProgram extends AutoProgram {

    @Override
    protected void defineSteps() {
        System.out.println("Auto enabled");
        // define a series of steps
        addStep(new DelayStep(5));
        addStep(new driveForwardStep(1, 0.5, 0.25, 2.1));
    }

    @Override
    public String toString() {
        // give it a name
        return "ExampleAutoProgram";
    }

}