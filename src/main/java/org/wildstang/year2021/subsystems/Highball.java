package org.wildstang.year2021.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;
import org.wildstang.framework.timer.WsTimer;
 

/**
 * Class:       Highball.java
 * Inputs:      1 digital buttons
 * Outputs:     1 victors
 * Description: raises the arm once when the left face button is pressed
 */

public class Highball implements Subsystem {
 
    //Inputs
    private DigitalInput leftButton; // Left Face Button
 
    //Motors
    private VictorSPX highballMotor; // idk what the motor type is

    //Motor Speeds
    private double highballMotorSpeed;

    //Constants
    private final double LIFT_SPEED = 0.25;
    private final double RAISE_TIME = 5;
    
    //States
    private boolean timerStatus;
    private boolean raising;
    private boolean raised;
    private boolean lowering;
    //Timer
    private WsTimer timer = new WsTimer();

 
    // initializes the subsystem
    public void init() {
 
        // register button and attach input listener with WS Input
        leftButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_LEFT.getName());
        leftButton.addInputListener(this);
        
        // create motor controller object with CAN Constant
        highballMotor = new VictorSPX(CANConstants.HIGHBALL_MOTOR);   // ADD TO CANS !!!

        timer.start();
        resetState();
    }
 
    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        highballMotor.set(ControlMode.PercentOutput, highballMotorSpeed);

        if (raising) {
            if (!timerStatus) {
                timer.reset();
                timer.start();
                timerStatus = true;
                highballMotorSpeed = LIFT_SPEED;
            } else if (timer.hasPeriodPassed(RAISE_TIME)) {
                raised = true;
                raising = false;
                timerStatus = false;
            }
        }
        else {if (lowering){
            if(!timerStatus){
                timer.reset();
                timer.start();
                timerStatus = true;
                highballMotorSpeed = -1*LIFT_SPEED;
            }else if(timer.hasPeriodPassed(RAISE_TIME)){
                raised = false;
                lowering = false;
                timerStatus = false;
            }
        }}

    }
 
    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (leftButton.getValue() && raised == false && !lowering) {
            raising = true;
        }
        if(leftButton.getValue()&& !raised && !raising){
            lowering = true;
        }
        
    }
 
    // used for testing
    public void selfTest() {}
 
    // resets all variables to the default state
    public void resetState() {
        highballMotorSpeed = 0;
        timerStatus = false;
        raising = false;
        raised = false;

    }
 
    // returns the unique name of the example
    public String getName() {
        return "Highball";
    }

    public void raiseArm(){
        raising = true;
    }
}
 