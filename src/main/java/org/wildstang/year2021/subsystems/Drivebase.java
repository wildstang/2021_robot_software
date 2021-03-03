package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       TestSubsystem.java
 * Inputs:      1 joystick
 * Outputs:     1 talon
 * Description: This is a testing subsystem that controls a single motor with a joystick.
 */
public class Drivebase implements Subsystem {

    // inputs
    //private AnalogInput joystick;
     /** Input to steer robot */
    private AnalogInput headingInput;
    /** Input to control forward-backward movement */
    private AnalogInput throttleInput;

    private AnalogInput countClockInput;
    private AnalogInput clockInput;
    // outputs
    private VictorSPX motorLeftFront;
    private VictorSPX motorLeftBack;
    private VictorSPX motorRightFront;
    private VictorSPX motorRightBack;

    // Commanded values
    /** The throttle value currently being commanded. */
    private double commandThrottle;
    /** The heading value currently being commanded. */
    private double commandHeading;
    
    private double commandRotation;
    // states
    private double speed;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        throttleInput = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y.getName());
        throttleInput.addInputListener(this);

        headingInput = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_X.getName());
        headingInput.addInputListener(this);

        countClockInput = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_TRIGGER_LEFT.getName());
        countClockInput.addInputListener(this);

        clockInput = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_TRIGGER_RIGHT.getName());
        clockInput.addInputListener(this);

        // create motor controller object with CAN Constant
        motorLeftFront = new VictorSPX(CANConstants.LEFT_FRONT_DRIVE_TALON);
        motorLeftBack = new VictorSPX(CANConstants.LEFT_BACK_DRIVE_TALON);
        motorRightFront = new VictorSPX(CANConstants.RIGHT_FRONT_DRIVE_TALON);
        motorRightBack = new VictorSPX(CANConstants.RIGHT_BACK_DRIVE_TALON);
       
        
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        //double leftSpeed = -throttleInput;
        //double rightSpeed =  throttleInput;
  //System.out.println("drive");

        double hypot = Math.pow(commandHeading, 2) + Math.pow(commandThrottle, 2);
        
        
        hypot = Math.sqrt(hypot);
        System.out.println(hypot);

        double thetaX = Math.asin(commandThrottle/hypot);
        if(commandHeading < 0){
            thetaX = Math.PI-thetaX;
        }
        System.out.println(thetaX);

        double leftSpeed = commandThrottle - commandThrottle * commandHeading;
        double rightSpeed = commandThrottle + commandThrottle * commandHeading;
        leftSpeed = -leftSpeed;

        double lfSpeed = leftSpeed;
        double lbSpeed = leftSpeed;
        double rfSpeed = rightSpeed;
        double rbSpeed = rightSpeed;

        lfSpeed = hypot * (-Math.sin(thetaX) - Math.cos(thetaX)) + commandRotation;
        rfSpeed = hypot * (Math.sin(thetaX)-Math.cos(thetaX)) + commandRotation;
        lbSpeed = hypot * (-Math.sin(thetaX)+Math.cos(thetaX)) + commandRotation;
        rbSpeed = hypot * (Math.sin(thetaX)+Math.cos(thetaX)) + commandRotation;



        motorRightFront.set(ControlMode.PercentOutput, rfSpeed);
        motorRightBack.set(ControlMode.PercentOutput, rbSpeed);
        motorLeftBack.set(ControlMode.PercentOutput, lbSpeed);
        motorLeftFront.set(ControlMode.PercentOutput, lfSpeed);



        //left motor throttle times heading, 
    }

    // respond to input updates
    public void inputUpdate(Input source) {
        // check to see which input was updated
        //if (signal == joystick) {
         //   speed = joystick.getValue();
        //}
        if (source == throttleInput) {
            setThrottle(throttleInput.getValue());
        } else if (source == headingInput) {
            setHeading(headingInput.getValue());
        } else if(source == countClockInput || source ==clockInput ){
            commandRotation = clockInput.getValue() + countClockInput.getValue();
        }
        //System.out.println("Clock Input:" + clockInput.getValue());
        //System.out.println("Count Clock Input:" + countClockInput.getValue());
        //System.out.println("Commandrotation:"+commandRotation);
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        speed = 0.0;
        setThrottle(0);
        setHeading(0);
    }

    // returns the unique name of the example
    public String getName() {
       return "Drive Base";
    }

     public void setHeading(double heading) {
        this.commandHeading = heading;
    }

    public void setThrottle(double throttle) {
        this.commandThrottle = throttle;
    }
}