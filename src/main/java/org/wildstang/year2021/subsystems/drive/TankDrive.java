package org.wildstang.year2021.subsystems.drive;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.AnalogInput;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       TankDrive.java
 * Inputs:      2 AnalogInput (Driver left joystick Y-axis and right joystick Y-axis), 1 DigitalInput (Driver A button)
 * Outputs:     2 TalonSRX (front), 2 VictorSPX (rear)
 * Description: Left joystick controls left motors, right joystick controls right motors, A button toggles turbo
 */
public class TankDrive implements Subsystem {

    // inputs
    private AnalogInput leftJoystick;
    private AnalogInput rightJoystickY;
    private AnalogInput rightJoystickX;
    private DigitalInput turboButton;
    private DigitalInput switchButton;

    // outputs
    private VictorSPX leftFrontMotor;
    private TalonSRX leftBackMotor;
    private VictorSPX rightFrontMotor;
    private TalonSRX rightBackMotor;

    // variables
    private boolean turboStatus = false;
    private boolean isArcade = false;
    private double leftSpeed = 0.0;
    private double rightSpeed = 0.0;
    private double normalSpeed = 1.0; // max speed when turbo is off
    private double turboSpeed = 0.0; // max speed when turbo is on
    private double maxSpeed = normalSpeed; // max speed is normal by default

    // deadzones must be positive double between 0.0 and 1.0
    private double leftDeadzone = 0.4;
    private double rightDeadzone = 0.4;

    // initializes the subsystem
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    public void initInputs() {
        leftJoystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y.getName());
        leftJoystick.addInputListener(this);
        rightJoystickY = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_Y.getName());
        rightJoystickY.addInputListener(this);
        rightJoystickX = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_RIGHT_JOYSTICK_X.getName());
        rightJoystickX.addInputListener(this);
        turboButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_DOWN.getName());
        turboButton.addInputListener(this);
        switchButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_LEFT.getName());
        switchButton.addInputListener(this);
    }

    public void initOutputs() {
        leftFrontMotor = new VictorSPX(CANConstants.LEFT_FRONT_DRIVE_VICTOR);
        leftBackMotor = new TalonSRX(CANConstants.LEFT_REAR_DRIVE_TALON);
        rightFrontMotor = new VictorSPX(CANConstants.RIGHT_FRONT_DRIVE_VICTOR);
        rightBackMotor = new TalonSRX(CANConstants.RIGHT_REAR_DRIVE_TALON);
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed*maxSpeed);
        leftBackMotor.set(ControlMode.PercentOutput, leftSpeed*maxSpeed);
        rightFrontMotor.set(ControlMode.PercentOutput, rightSpeed*maxSpeed);
        rightBackMotor.set(ControlMode.PercentOutput, rightSpeed*maxSpeed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        if (signal == switchButton) {
            isArcade = !isArcade;
            System.out.println("isArcade = " + isArcade);
        }

        // tank drive
        if (!isArcade) {
            // update left motor speeds
            if (Math.abs(leftJoystick.getValue()) > leftDeadzone) {
                leftSpeed = leftJoystick.getValue()*-1.0;
            }
            else {
                leftSpeed = 0.0;
            }
            // update right motor speeds
            if (Math.abs(rightJoystickY.getValue()) > rightDeadzone) {
                rightSpeed = rightJoystickY.getValue();
            }
            else {
                rightSpeed = 0.0;
            }
        }
        // arcade drive
        else {
            if (!turboButton.getValue()) {
                leftSpeed = (1.0 - rightJoystickX.getValue());
                rightSpeed = (1.0 + rightJoystickX.getValue());
            }
            else {
                leftSpeed = (rightJoystickX.getValue()*-1.0);
                rightSpeed = (rightJoystickX.getValue());
            }
            double avg = (Math.abs(leftSpeed)+Math.abs(rightSpeed))*0.5;
            leftSpeed = leftJoystick.getValue()*(leftSpeed/avg);
            rightSpeed = leftJoystick.getValue()*(rightSpeed/avg);
            if (Math.abs(leftJoystick.getValue()) < leftDeadzone){
                leftSpeed = 0.0;
                rightSpeed = 0.0;
            }
        }

        // update max speed
        // if (signal == turboButton) {
        //     if (!turboStatus) {
        //         turboStatus = true;
        //         maxSpeed = turboSpeed;
        //     }
        //     else {
        //         turboStatus = false;
        //         maxSpeed = normalSpeed;
        //     }
        // }
    }

    // helper methods for autonomous
    public void setLeftMotorSpeed(double s) {
        leftSpeed = s;
    }

    public void setRightMotorSpeed(double s) {
        rightSpeed = s;
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        leftSpeed = 0.0;
        rightSpeed = 0.0;
        maxSpeed = normalSpeed;
        turboStatus = false;
        isArcade = false;
    }

    // returns the unique name of the subsystem
    public String getName() {
        return "Drive";
    }
}