package org.wildstang.year2021.auto.programs;

import org.wildstang.framework.auto.AutoProgram;
import org.wildstang.year2021.auto.steps.DelayStep;
import org.wildstang.year2021.auto.steps.RunIntakeStep;
import org.wildstang.year2021.auto.steps.RunHopperStep;
import org.wildstang.year2021.auto.steps.DriveForwardsStep;
import org.wildstang.year2021.auto.steps.DriveBackwardsStep;
import org.wildstang.year2021.auto.steps.ArmUpwardsStep;
import org.wildstang.year2021.auto.steps.ArmDownwardsStep;

/**
 * This is the framework of an Autonomous Program.
 * Autonomous programs control the robot without any driver/manipulator input.
 * These programs work by defining a series of steps in the "defineSteps" functions.
 * The "toString" function defines a name for the program.
 */
public class SafeAutoWithArmProgram extends AutoProgram {

    @Override
    protected void defineSteps() {
        // begin lifting arm ~0s
        addStep(new ArmUpwardsStep(1.0));
        // deploy intake ~0s
        addStep(new RunIntakeStep(1.0));
        addStep(new DelayStep(1.0));
        addStep(new RunIntakeStep(0.0));
        // run intake normally ~1s
        addStep(new RunIntakeStep(-1.0));
        // drive forwards ~1s
        addStep(new DriveForwardsStep(0.3));
        addStep(new DelayStep(1.2));
        addStep(new DriveForwardsStep(0.0));
        // collect balls ~2.2s
        addStep(new DelayStep(1.8));
        // stop arm lift and lower it ~4s
        addStep(new ArmUpwardsStep(0.0));
        addStep(new ArmDownwardsStep(1.0));
        // continue collecting balls ~4s
        addStep(new DelayStep(2.2));
        // drive backwards ~6.2s
        addStep(new DriveBackwardsStep(0.3));
        addStep(new DelayStep(1.2));
        addStep(new DriveBackwardsStep(0.0));
        // run hopper ~7.4s
        addStep(new RunHopperStep(1.0));
        addStep(new DelayStep(0.6));
        // stop arm lower ~8s
        addStep(new ArmDownwardsStep(0.0));
        // wait for fuel cells to outtake ~8s
        addStep(new DelayStep(4));
        // stop hopper and intake
        addStep(new RunHopperStep(0.0));
        addStep(new RunIntakeStep(0.0));
    }

    @Override
    public String toString() {
        return "SafeAutoWithArmProgram";
    }

}