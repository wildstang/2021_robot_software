package org.wildstang.year2021.auto.steps;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.robot.WSSubsystems;
import org.wildstang.year2021.subsystems.SwerveDrive;

public class PathHeadingStep extends AutoStep {

    private SwerveDrive m_drive;
    private double heading;

    public PathHeadingStep(double heading) {
        this.heading = heading;
        m_drive = (SwerveDrive) Core.getSubsystemManager().getSubsystem(WSSubsystems.SwerveDrive.getName());
    }

    @Override
    public void initialize() {
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
