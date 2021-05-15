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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 

/**
 * Class:       Highball.java
 * Inputs:      1 digital buttons
 * Outputs:     1 victors
 * Description: raises the arm once when the left face button is pressed.
 * Lowers the arm if it is pressed again.
 */

public class Highball implements Subsystem {
 
    //Inputs
    private DigitalInput leftButton; // Left Face Button (MANIPULATOR)
 
    //Motors
    private VictorSPX highballMotor; // idk what the motor type is

    //Motor Speeds
    private double highballMotorSpeed;

    //Constants
    private final double LIFT_SPEED = 0.21;
    private final double RAISE_TIME = 0.6;
    private double STAY_POWER = 0.1;
    private double STAY_TIME = 10;
    
    private double KeepSpeed = 0.1;
    //States
    private boolean timerStatus;

    //Timer
    private WsTimer timer = new WsTimer();

    enum commands {
        IDLE, RAISING, RAISED, LOWERING, LOWERED,OVERRIDE;   
    }
    private commands currentCommand; // 0 = IDLE x
                                     // 1 = RAISING x
                                     // 2 = RAISED /
                                     // 3 = LOWERING
                                     // 3 = LOWERED

 
    // initializes the subsystem
    public void init() {
 
        // register button and attach input listener with WS Input
        leftButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_FACE_LEFT.getName());
        leftButton.addInputListener(this);
        
        // create motor controller object with CAN Constant
        highballMotor = new VictorSPX(CANConstants.HIGHBALL_MOTOR);   // ADD TO CANS !!!

        timer.start();
        resetState();
    }
 
    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        highballMotor.set(ControlMode.PercentOutput, highballMotorSpeed);
        SmartDashboard.putNumber("highbell motor speed",highballMotorSpeed);

        if (currentCommand == commands.IDLE) {
            highballMotorSpeed = 0;
            timerStatus = false;
        }
        // Begin  from Idle -> Raising -> Raised
        if (currentCommand == commands.RAISING) {
            if (!timerStatus) {
                timer.reset();
                timer.start();
                timerStatus = true;
                highballMotorSpeed = LIFT_SPEED;
            } else if (timer.hasPeriodPassed(RAISE_TIME)) {
                currentCommand = commands.RAISED;
                timerStatus = false;
                highballMotorSpeed = STAY_POWER;
            }
        }
        if (currentCommand == commands.RAISED) {
            if (!timerStatus) {
                timer.reset();
                timer.start();
                timerStatus = true;
                highballMotorSpeed = STAY_POWER;
            } else if (timer.hasPeriodPassed(STAY_TIME)) {
                currentCommand = commands.IDLE;
                timerStatus = false;
                highballMotorSpeed = 0;
            }
        }
        if (currentCommand == commands.OVERRIDE){
            highballMotorSpeed = KeepSpeed;
        }

        // Begin  from RAISED -> LOWERING -> LOWERED -> IDLE
        
            //CURRENTLY DISABLED

        if (currentCommand == commands.LOWERING) {
            if (!timerStatus) {
                timer.reset();
                timer.start();
                timerStatus = true;
                highballMotorSpeed = -LIFT_SPEED;
            } else if (timer.hasPeriodPassed(RAISE_TIME)) {
                currentCommand = commands.LOWERED;
            }
        }
        if (currentCommand == commands.LOWERED) {
            highballMotorSpeed = 0;
            timerStatus = false;
            currentCommand = commands.IDLE;
        }
        

        
        
    }
 
    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (leftButton.getValue() && (currentCommand == commands.IDLE || currentCommand == commands.RAISED)) {
            currentCommand = commands.RAISING;
            }
        //if(leftButton.getValue() && currentCommand == commands.RAISED){ //DISABLED
            //currentCommand = commands.LOWERING;
        //}
        
    }
 
    // used for testing
    public void selfTest() {}
 
    // resets all variables to the default state
    public void resetState() {
        highballMotorSpeed = 0;
        timerStatus = false;    
        currentCommand = commands.IDLE;
    }
 
    // returns the unique name of the example
    public String getName() {
        return "Highball";
    }

    public void raiseArm(){
        if (currentCommand == commands.IDLE) {
            currentCommand = commands.RAISING;
        }
    }
    public void KeepUp(){
        if (currentCommand == commands.RAISED) {
            currentCommand = commands.OVERRIDE;
        }
    }
    public boolean isRaised(){
        if (currentCommand == commands.RAISED) {
            return true;
        } else {
            return false;
        }
    }
}
 