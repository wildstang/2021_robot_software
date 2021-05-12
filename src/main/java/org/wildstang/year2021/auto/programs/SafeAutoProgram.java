package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.RunIntakeStep;
import org.wildstang.year2021.auto.steps.RunHopperStep;
import org.wildstang.year2021.auto.steps.DriveForwardsStep;
import org.wildstang.year2021.auto.steps.DriveBackwardsStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class SafeAutoProgram extends AutoProgram {

    @Override
    protected void defineSteps() {
        // deploy intake
        addStep(new RunIntakeStep(1.0));
        addStep(new DelayStep(1.0));
        addStep(new RunIntakeStep(0.0));
        // run intake normally
        addStep(new RunIntakeStep(-1.0));
        // drive forwards
        addStep(new DriveForwardsStep(0.3));
        addStep(new DelayStep(1.2));
        addStep(new DriveForwardsStep(0.0));
        // collect balls
        addStep(new DelayStep(4.0));
        // drive backwards
        addStep(new DriveBackwardsStep(0.3));
        addStep(new DelayStep(1.2));
        addStep(new DriveBackwardsStep(0.0));
        // run hopper
        addStep(new RunHopperStep(1.0));
        // wait for fuel cells to outtake
        addStep(new DelayStep(4));
        // stop hopper and intake
        addStep(new RunHopperStep(0.0));
        addStep(new RunIntakeStep(0.0));
    }

    @Override
    public String toString() {
        return "SafeAutoProgram";
    }

}