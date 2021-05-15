package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.DriveForwardsStep;
import org.wildstang.year2021.auto.steps.DriveBackwardsStep;
import org.wildstang.year2021.auto.steps.DriveLeftBackwardsStep;
import org.wildstang.year2021.auto.steps.DriveLeftForwardsStep;
import org.wildstang.year2021.auto.steps.DriveLeftBackwardsStep;
import org.wildstang.year2021.auto.steps.DriveRightForwardsStep;
import org.wildstang.year2021.auto.steps.DriveRightBackwardsStep;
import org.wildstang.year2021.auto.steps.ArmUpwardsStep;
import org.wildstang.year2021.auto.steps.ArmDownwardsStep;
import org.wildstang.year2021.auto.steps.RunIntakeStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class CrazyAutoProgram extends AutoProgram {

    @Override
    protected void defineSteps() {
        // lift arm ~0s
        addStep(new ArmUpwardsStep());
        // deploy intake ~0s
        addStep(new RunIntakeStep(1.0));
        addStep(new DelayStep(1.0));
        addStep(new RunIntakeStep(0.0));
        // move backwards ~1s
        addStep(new DriveBackwardsStep(0.3));
        addStep(new DelayStep(1.0));
        addStep(new DriveBackwardsStep(0.0));
        // wait for arm to finish lifting to deploy, then stop ~2s
        addStep(new DelayStep(1.5));
        addStep(new ArmUpwardsStep(0.0));
        // wait for meditation ~3.5s
        addStep(new DelayStep(0.5));
        // align with black fuel cell tower ~4s
        addStep(new DriveLeftBackwardsStep(0.425));
        addStep(new DelayStep(0.912));
        addStep(new DriveLeftBackwardsStep(0.0));
        addStep(new DelayStep(0.088));
        // approach black fuel cell tower ~5s
        addStep(new DriveBackwardsStep(0.4));
        addStep(new DelayStep(0.5));
        addStep(new DriveBackwardsStep(0.0));
        // ~5.5s
        addStep(new ArmUpwardsStep());
        addStep(new DelayStep(3.5));
        addStep(new ArmUpwardsStep(0.0));
        // wait for ball to roll down into hopper ~9s
        addStep(new DelayStep(2));
        // pivot left and right to attempt to knock off ball in case it's still there ~10.5s
        addStep(new DriveLeftBackwardsStep(0.5));
        addStep(new DriveRightForwardsStep(0.5));
        addStep(new DelayStep(0.5));
        addStep(new DriveLeftBackwardsStep(0.0));
        addStep(new DriveRightForwardsStep(0.0));
        //
        addStep(new DriveRightBackwardsStep(0.5));
        addStep(new DriveLeftForwardsStep(0.5));
        addStep(new DelayStep(1.0));
        addStep(new DriveRightBackwardsStep(0.0));
        addStep(new DriveLeftForwardsStep(0.0));
        //
        addStep(new DriveLeftBackwardsStep(0.5));
        addStep(new DriveRightForwardsStep(0.5));
        addStep(new DelayStep(0.5));
        addStep(new DriveLeftBackwardsStep(0.0));
        addStep(new DriveRightForwardsStep(0.0));
        // move forwards a bit ~11.75s
        addStep(new DelayStep(0.5));
        addStep(new DriveForwardsStep(0.3));
        addStep(new DelayStep(0.5));
        addStep(new DriveForwardsStep(0.0));
        addStep(new DelayStep(0.5));
        // // lower arm
        // addStep(new ArmDownwardsStep());
        // addStep(new DelayStep(8));
        // addStep(new ArmDownwardsStep(0.0));
        // addStep(new DelayStep(0.5));
    }

    @Override
    public String toString() {
        return "CrazyAutoProgram";
    }

}