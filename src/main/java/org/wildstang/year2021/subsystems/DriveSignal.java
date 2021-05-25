package org.wildstang.year2021.subsystems;

public class DriveSignal {

    private double[] speed;
    private double[] angle;
    private double maxSpeed;

    //contains motor speeds, robot relative angles in bearing-degrees
    public DriveSignal(double[] i_speed, double[] i_angle){
        this.speed = i_speed;
        this.angle = i_angle;
    }

    //ensures all speed values are below 1, and scales down if needed
    public void normalize(){
        maxSpeed = 1;
        for (int i = 0; i < speed.length; i++){
            if (Math.abs(speed[i]) > maxSpeed){
                maxSpeed = Math.abs(speed[i]);
            }
        }
        for (int i = 0; i < speed.length; i++){
            speed[i] /= maxSpeed;
        }
    }
    //speed is normalized value [0, 1]
    public double getSpeed(int i_module){
        return speed[i_module];
    }
    //angle is bearing, in degrees
    public double getAngle(int i_module){
        return angle[i_module];
    }
    
}
