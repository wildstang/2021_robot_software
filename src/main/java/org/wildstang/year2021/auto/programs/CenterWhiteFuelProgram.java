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
public class CenterWhiteFuelProgram extends AutoProgram {

    @Override
    protected void defineSteps() {
        // starts the roller and drives towards the center
        addStep(new DriveForwardsStep());
        addStep(new RunIntakeStep());
        addStep(new DelayStep(2));
        // stops driving forward and pauses for a second to gather balls, then turns off the intake
        addStep(new DriveForwardsStep(0));
        addStep(new DelayStep(2));
        addStep(new RunIntakeStep(0));
        // drives backwards to prepare to spin
        addStep(new DriveBackwardsStep(1);
        addStep(new DelayStep(1));
        addStep(new DriveBackwardsStep(0));
        // spins, then stops
        addStep(new DriveLeftBackwardsStep());
        addStep(new DriveRightForwardsStep());
        addStep(new DelayStep(2));
        addStep(new DriveLeftBackwardsStep(0));
        addStep(new DriveRightForwardsStep(0));
        // Drives back to tower
        addStep(new DriveBackwardsStep());
        addStep(new DelayStep(0.5));
        addStep(new DriveBackwardsStep(0));
        // lift arm
        addStep(new ArmUpwardsStep());
        addStep(new DelayStep(1));
        addStep(new ArmUpwardsStep(0.0));
        addStep(new DelayStep(0.5));
        // wait for ball to roll down into hopper
        addStep(new DelayStep(1));
        // lower arm
        addStep(new ArmDownwardsStep());
        addStep(new DelayStep(1));
        addStep(new ArmDownwardsStep(0.0));
        addStep(new DelayStep(0.5));
    }

    @Override
    public String toString() {
        return "CenterWhiteFuelProgram";
    }

}