package org.wildstang.year2021.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
 
import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;
 
 
/**
 * Class:       Drive.java
 * Inputs:      2 joystick
 * Outputs:     2 Victor SPX
 * Description: This the drive train subsystem that controls 2 motors with 2 joysticks.
 */
public class Drive implements Subsystem {
 
    // inputs
    private AnalogInput leftJoystick;
    private AnalogInput rightJoystick;
 
    // outputs
    private TalonSRX leftMotor; 
    private TalonSRX rightMotor;
 
    // states
    private double leftSpeed;
    private double rightSpeed;
 
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
        
        resetState();
    }
 
    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        //I dont know whats, leftMotor and rightMotor are initialized on lines 27 & 28
        leftMotor.set(ControlMode.PercentOutput, leftSpeed);
        rightMotor.set(ControlMode.PercentOutput, rightSpeed);
    }
 
    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        leftSpeed = leftJoystick.getValue();
        rightSpeed = rightJoystick.getValue();
 
    }
 
    // used for testing
    public void selfTest() {}
 
    // resets all variables to the default state
    public void resetState() {
        leftSpeed = 0;
        rightSpeed = 0;
    }
 
    // returns the unique name of the example
    public String getName() {
        return "Drivetrain";
    }
}
 
