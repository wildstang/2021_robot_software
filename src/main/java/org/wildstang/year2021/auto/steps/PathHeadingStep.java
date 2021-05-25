package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.year2021.subsystems.SwerveDrive;

public class PathHeadingStep extends AutoStep {

    private SwerveDrive m_drive;
    private double heading;

    /** sets the robot in auto to face a certain direction, and stay facing that way
     * finishes automatically, just passes a value
     * @param heading field-centric value robot will align towards, in bearing degrees
     */
    public PathHeadingStep(double heading) {
        this.heading = heading;
        m_drive = (SwerveDrive) Core.getSubsystemManager().getSubsystem(WSSubsystems.SwerveDrive.getName());
    }

    @Override
    public void initialize() {
        //give robot heading controller a new value
        m_drive.setAutoHeading(heading);
    }

    @Override
    public void update() {
        setFinished(true);
    }

    @Override
    public String toString() {
        return "Path Heading";
    }

}
