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
 
 
/**
 * Class:       Drive.java
 * Inputs:      2 joystick
 * Outputs:     2 Victor SPX
 * Description: This the drive train subsystem that controls 2 motors with 2 joysticks. 
 * Default mode uses vertical positions of joysticks for motor powers.
 * Alternate mode uses left joystick for throttle,  right joystick horizontal axis for steering, and face down for quickturn.
 * Click select to change modes.
 */
public class Drive implements Subsystem {
 
    // inputs
    private AnalogInput leftJoystick;
    private AnalogInput rightJoystick;

    private AnalogInput rightHorizontal;
    private DigitalInput selectMode;
    private DigitalInput quickButton; //for alt controls
    // outputs
    private TalonSRX leftMotor; 
    private TalonSRX rightMotor;
 
    // states
    public double leftSpeed;
    public double rightSpeed;

    private boolean altControl; //is it on alternate control mode?
    private boolean lastValue; 

    public double DeadBand = 0.08;
    // initializes the subsystem
    public void init() {
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
        
        selectMode = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_SELECT.getName());
        selectMode.addInputListener(this);

        quickButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_DOWN.getName());
        quickButton.addInputListener(this);
        resetState();
    }
 
    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        leftMotor.set(ControlMode.PercentOutput, leftSpeed);
        rightMotor.set(ControlMode.PercentOutput, -rightSpeed);
    }
 
    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if ((selectMode.getValue() != lastValue)&&(selectMode.getValue())){
            altControl = !altControl;  
        }
        lastValue = selectMode.getValue();
        if(!altControl){ //two throttle mode
            leftSpeed = leftJoystick.getValue();
            rightSpeed = rightJoystick.getValue();
            if(Math.abs(leftSpeed)<DeadBand){
                leftSpeed = 0;
            }
            if(Math.abs(rightSpeed)<DeadBand){
                rightSpeed = 0;
            }
        }
        else{ //throttle and steer mode
            if (!quickButton.getValue()){
            leftSpeed = (1-rightHorizontal.getValue());
            rightSpeed = (1+rightHorizontal.getValue());
            }
            else{ //when quickturning, pivot without moving forward
                leftSpeed = (-1*rightHorizontal.getValue());
                rightSpeed = (rightHorizontal.getValue());
            }
            double norm = 0.5*(Math.abs(leftSpeed)+Math.abs(rightSpeed));
            rightSpeed = leftJoystick.getValue()*(rightSpeed/norm);
            leftSpeed = leftJoystick.getValue()*(leftSpeed/norm);
            if(Math.abs(leftJoystick.getValue())<DeadBand){
                rightSpeed = 0;
                leftSpeed = 0;
            }
        }
    }
 
    // used for testing
    public void selfTest() {}
 
    // resets all variables to the default state
    public void resetState() {
        leftSpeed = 0;
        rightSpeed = 0;
        altControl = false;
        lastValue = false;
        ResetEncoders();
    }
    public void ResetEncoders(){
        leftMotor.getSensorCollection().setQuadraturePosition(0,0);
        rightMotor.getSensorCollection().setQuadraturePosition(0,0);
    }
    public double GetRightEncoder(){
        return rightMotor.getSensorCollection().getQuadraturePosition();
    }
    public double GetLeftEncoder(){
        return leftMotor.getSensorCollection().getQuadraturePosition();
    }
 
    // returns the unique name of the example
    public String getName() {
        return "Drivetrain";
    }
}
 
