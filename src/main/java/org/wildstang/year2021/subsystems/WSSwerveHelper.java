package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.subsystems.DriveSignal;
import org.wildstang.year2021.subsystems.DriveConstants;

public class WSSwerveHelper {

    private double magnitude;
    private double direction;
    private DriveSignal driveSignal;
    private double rotMag;
    private double baseV;
    private double[] xCoords = new double[]{0.0, 0.0, 0.0, 0.0};
    private double[] yCoords = new double[]{0.0, 0.0, 0.0, 0.0};
    private double rotDelta;
    private double rotPID;


    public DriveSignal setCross(){
        return new DriveSignal(new double[]{0.0, 0.0, 0.0, 0.0}, new double[]{135.0, 45.0, 45.0, 135.0});
    }

    public DriveSignal setCrab(double i_tx, double i_ty, double i_gyro){
        magnitude = getMagnitude(i_tx, i_ty);
        direction = getDirection(i_tx, i_ty, i_gyro);
        return new DriveSignal(new double[]{magnitude, magnitude, magnitude, magnitude}, new double[]{direction, direction, direction, direction});
    }

    public DriveSignal setDrive(double i_tx, double i_ty, double i_rot, double i_gyro){
        //magnitude of rotation vector
        rotMag = i_rot * DriveConstants.ROTATION_SPEED;
        //angle of front left rotation vector
        baseV = Math.atan(DriveConstants.ROBOT_LENGTH / DriveConstants.ROBOT_WIDTH);

        //cartesian vector addition of translation and rotation vectors
        //note rotation vector angle advances in the cos -> sin -> -cos -> -sin fashion
        xCoords = new double[]{i_tx + rotMag*Math.cos(baseV), i_tx + rotMag*Math.sin(baseV), i_tx - rotMag*Math.cos(baseV), i_tx - rotMag*Math.sin(baseV)}; 
        yCoords = new double[]{i_ty + rotMag*Math.sin(baseV), i_ty - rotMag*Math.cos(baseV), i_ty - rotMag*Math.sin(baseV), i_ty + rotMag*Math.cos(baseV)};

        //create drivesignal, with magnitudes and directions of x and y
        driveSignal = new DriveSignal(new double[]{getMagnitude(xCoords[0], yCoords[0]), getMagnitude(xCoords[1], yCoords[1]), getMagnitude(xCoords[2], yCoords[2]), getMagnitude(xCoords[3], yCoords[3])}, 
            new double[]{getDirection(xCoords[0], yCoords[0], i_gyro), getDirection(xCoords[1], yCoords[1], i_gyro), getDirection(xCoords[2], yCoords[2], i_gyro), getDirection(xCoords[3], yCoords[3], i_gyro)});
        driveSignal.normalize();
        return driveSignal;
    }

    public DriveSignal setAuto(double i_power, double i_heading, double i_rot, double i_gyro){
        return setDrive(i_power * Math.cos(Math.toRadians(i_heading)), i_power * Math.sin(Math.toRadians(i_heading)), i_rot, i_gyro);
    }

    public double getRotControl(double i_target, double i_gyro){
        rotDelta = i_target - i_gyro;
        if (rotDelta > 180){
            rotPID = -rotDelta/360.0;
        } else if (Math.abs(rotDelta) <= 180.0){
            rotPID = -rotDelta/360.0;
        } else {
            rotPID = -1 -rotDelta/360.0;
        } 
        return rotPID*DriveConstants.ROTATION_SPEED;
    }
    public double getAutoPower(double pathPos, double pathVel, double distTravelled){
        double guess = pathVel * DriveConstants.DRIVE_F;
        double check = DriveConstants.DRIVE_P * (pathPos - distTravelled);
        return -(guess + check);
    }

    //returns magnitude of vector components
    private double getMagnitude(double x, double y){
        return Math.hypot(x, y);
    }
    //x,y inputs are cartesian, angle values are in bearing, returns 0 - 360
    private double getDirection(double x, double y, double angle){
        double measurement =  Math.toDegrees(Math.atan2(x,y));//returns angle in bearing form
        if (measurement<0) measurement = 360+measurement;
        measurement = measurement - angle;
        if (measurement<0) measurement = 360+measurement;
        return measurement;
    }
    
}
