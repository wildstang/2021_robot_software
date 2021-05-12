package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.StopStep;
import org.wildstang.year2021.auto.steps.DriveForwardStep;
import org.wildstang.year2021.auto.steps.intakeOffStep;
import org.wildstang.year2021.auto.steps.hopperOffStep;
import org.wildstang.year2021.auto.steps.hopperOnStep;
import org.wildstang.year2021.auto.steps.intakeOnStep;
import org.wildstang.year2021.auto.steps.DriveAngleStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class SpecialFuel extends AutoProgram {

    @Override
    protected void defineSteps() {
        // define a series of step
        addStep(new DriveAngleStep(0.25,1,1));
        addStep(new DriveForwardStep(0.15, -0.4));
        addStep(new DriveAngleStep(3,1,1));
        addStep(new StopStep());
        addStep(new intakeOffStep());
        addStep(new hopperOffStep());
    }

    @Override
    public String toString() {
        // give it a name
        return "Forward Program";
    }

}