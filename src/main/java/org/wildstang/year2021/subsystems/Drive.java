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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

 
/**
 * Class:       Drive.java
 * Inputs:      2 joystick
 * Outputs:     2 Victor SPX
 * Description: This the drive train subsystem that controls 2 motors with 2 joysticks. 
 * Default mode uses vertical positions of joysticks for motor powers.
 * Alternate mode uses left joystick for throttle,  right joystick horizontal axis for steering, and face down for quickturn.
 * Click start to change modes.
 */
public class Drive implements Subsystem {
 
    // inputs
    private AnalogInput leftJoystick;
    private AnalogInput rightJoystick;

    private AnalogInput rightHorizontal;
    private DigitalInput selectMode;
    private DigitalInput quickButton; //for alt controls

    private AnalogInput rightTrigger;
    private AnalogInput leftTrigger;
    //private AnalogInput gyro;

    // outputs
    private TalonSRX leftMotor; 
    private TalonSRX rightMotor;


    private double testing;
    // states
    public double leftSpeed;
    public double rightSpeed;

    private boolean altControl; //is it on alternate control mode?

    public double DeadBand = 0.04;
    // initializes the subsystem
    public void init() {
        testing = 0;
        // create motor controller object with CAN Constant
        leftMotor = new TalonSRX(CANConstants.DRIVE_LEFT);
        rightMotor = new TalonSRX(CANConstants.DRIVE_RIGHT);

 
        // register button and attach input listener with WS Input
        leftJoystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y.getName());
        leftJoystick.addInputListener(this);
        rightJoystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_Y.getName());
        rightJoystick.addInputListener(this);
        rightHorizontal = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_X.getName());
        rightHorizontal.addInputListener(this);

        rightTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_TRIGGER.getName());
        rightTrigger.addInputListener(this);
        leftTrigger = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_TRIGGER.getName());
        leftTrigger.addInputListener(this);
        
        selectMode = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_START.getName());
        selectMode.addInputListener(this);
        quickButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_DOWN.getName());
        quickButton.addInputListener(this);
        resetState();
    }
 
    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        leftMotor.set(ControlMode.PercentOutput, leftSpeed);
        rightMotor.set(ControlMode.PercentOutput, -rightSpeed);
        SmartDashboard.putNumber("RightTrigger", testing);
        SmartDashboard.putNumber("left speed", leftSpeed);
        SmartDashboard.putNumber("right speed", rightSpeed);
        //SmartDashboard.putNumber("gyro reading", gyro.getValue());
        SmartDashboard.putNumber("left encoder",leftMotor.getSensorCollection().getQuadraturePosition());
        SmartDashboard.putNumber("right encoder",rightMotor.getSensorCollection().getQuadraturePosition());
    }
 
    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (selectMode.getValue()&&(signal == selectMode)) {
            altControl = !altControl;  
        }
        
        if (!altControl) { //two throttle mode
            leftSpeed = leftJoystick.getValue();
            rightSpeed = rightJoystick.getValue();
            if (Math.abs(leftSpeed)<DeadBand) 
                {  leftSpeed = 0;  }
            if (Math.abs(rightSpeed)<DeadBand) 
                {  rightSpeed = 0;  }
        
        } else { //throttle and steer mode
            
            leftSpeed = (1+rightHorizontal.getValue());
            rightSpeed = (1-rightHorizontal.getValue());

            if (leftSpeed>1){ leftSpeed = 1;}
            if (rightSpeed>1){ rightSpeed = 1;}
            //double norm = 0.5*(Math.abs(leftSpeed)+Math.abs(rightSpeed));
            rightSpeed = leftJoystick.getValue()*(rightSpeed);
            leftSpeed = leftJoystick.getValue()*(leftSpeed);
            if (Math.abs(leftJoystick.getValue())<DeadBand) {
                leftSpeed = (-1*rightHorizontal.getValue());
                rightSpeed = (rightHorizontal.getValue());
            }
        }
        testing = rightTrigger.getValue();
        if((-1*rightTrigger.getValue()>DeadBand)&&(-1*rightTrigger.getValue()>leftTrigger.getValue())){
            leftSpeed = -1*rightTrigger.getValue();
            rightSpeed = rightTrigger.getValue();
        }
        if((leftTrigger.getValue()>DeadBand)&&(leftTrigger.getValue()>-1*rightTrigger.getValue())){
            leftSpeed = -1*leftTrigger.getValue();
            rightSpeed = leftTrigger.getValue();

        }
    }
 
    // used for testing
    public void selfTest() {}
 
    // resets all variables to the default state
    public void resetState() {
        leftSpeed = 0;
        rightSpeed = 0;
        altControl = false;
        ResetEncoders();
    }

    public void ResetEncoders(){
        leftMotor.getSensorCollection().setQuadraturePosition(0,0);
        rightMotor.getSensorCollection().setQuadraturePosition(0,0);
    }
    public double GetRightEncoder(){
        return -1*rightMotor.getSensorCollection().getQuadraturePosition(); //inverted because motor is running oppisite direction
    }
    public double GetLeftEncoder(){
        return leftMotor.getSensorCollection().getQuadraturePosition();
    }
    public double GetGyroValue(){
        //return gyro.getValue();
        return 0;
    }

    public void SetBothSpeeds(double speedR, double speedL){
        rightSpeed = speedR;
        leftSpeed = speedL;
    }
    public void SetRightSpeed(double speed){
        rightSpeed = speed;
    }
    public void SetLeftSpeed(double speed){
        leftSpeed = speed;
    }

    // returns the unique name of the example
    public String getName() {
        return "Drive";
    }
}
 
