package org.wildstang.year2021.auto.steps;

import java.io.File;

import org.wildstang.framework.auto.steps.AutoStep;
import org.wildstang.framework.core.Core;
import org.wildstang.year2021.subsystems.SwerveDrive;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PathFollowerStep extends AutoStep {

    private static final double ftToIn = 12;
    private static final double radToDeg = 180/Math.PI;
    private static final int positionP = 7;
    private static final int velocityP = 8;
    private static final int headingP = 15;
    //dt, x, y, leftPos, leftVel, leftAcc, leftJer, centerPos, centerVel, centerAcc, centerJer, rightPos, rightVel, rightAcc, rightJer, heading
    //0   1  2    3          4       5        6          7          8         9          10        11         12       13        14       15

    private SwerveDrive m_drive;
    private double[][] pathData;

    private int counter = 0;

    public PathFollowerStep(double[][] pathData) {
        this.pathData = pathData;
    }

    @Override
    public void initialize() {
        //start path
        //tell the swerve to run a path
        //give it pathData
    }

    @Override
    public void update() {
        if (counter >= pathData.length){
            //end path
            setFinished(true);
        } else {
           //update from pathData[counter][either positionP, velocityP, or headingP]
           //
            counter++;
        }
    }

    @Override
    public String toString() {
        return "Path Follower";
    }

}
