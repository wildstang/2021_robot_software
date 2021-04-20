package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DriveForwardsStep;
import org.wildstang.year2021.auto.steps.DriveBackwardsStep;
import org.wildstang.year2021.auto.steps.DriveLeftForwardsStep;
import org.wildstang.year2021.auto.steps.DriveLeftBackwardsStep;
import org.wildstang.year2021.auto.steps.DriveRightForwardsStep;
import org.wildstang.year2021.auto.steps.ArmUpwardsStep;
import org.wildstang.year2021.auto.steps.ArmDownwardsStep;
import org.wildstang.year2021.auto.steps.DelayStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class RetrieveWhiteFuelRight extends AutoProgram {

    @Override
    protected void defineSteps() {
        // move forwards away from the black fuel cell tower
        addStep(new DriveForwardsStep(1.0));
        addStep(new DelayStep(1.0));
        addStep(new DriveForwardsStep(0.0));
        addStep(new DelayStep(0.5));
        // turn back to the starting position
        addStep(new DriveLeftForwardsStep(1.0));
        addStep(new DelayStep(0.5));
        addStep(new DriveLeftForwardsStep(0.0));
        addStep(new DelayStep(0.5));
        // cross the field
        addStep(new DriveForwardsStep(1.0));
        addStep(new DelayStep(4));
        addStep(new DriveForwardsStep(1.0));
        addStep(new DelayStep(0.5));
        // rotate the robot so that the back end/arm is aligned with the white fuel cell tower
        addStep(new DriveLeftBackwardsStep(1.0));
        addStep(new DriveRightForwardsStep(1.0));
        addStep(new DelayStep(1));
        addStep(new DriveLeftBackwardsStep(0.0));
        addStep(new DriveRightForwardsStep(0.0));
        addStep(new DelayStep(0.5));
        // approach white fuel cell tower
        addStep(new DriveBackwardsStep(0.5));
        addStep(new DelayStep(1));
        addStep(new DriveBackwardsStep(0.0));
        addStep(new DelayStep(0.5));
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
    }

    @Override
    public String toString() {
        return "RetrieveWhiteFuelRight";
    }

}