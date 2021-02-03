package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

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
public class TestSubsystem implements Subsystem {

    // inputs
    //private AnalogInput joystick;
     /** Input to steer robot */
    private AnalogInput headingInput;
    /** Input to control forward-backward movement */
    private AnalogInput throttleInput;
    // outputs
    private TalonSRX motorLeftFront;
    private TalonSRX motorLeftBack;
    private TalonSRX motorRigtFront;
    private TalonSRX motorRightBack;

    // Commanded values
    /** The throttle value currently being commanded. */
    private double commandThrottle;
    /** The heading value currently being commanded. */
    private double commandHeading;
    
    // states
    private double speed;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        joystick = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_LEFT_JOYSTICK_Y.getName());
        joystick.addInputListener(this);

        // create motor controller object with CAN Constant
        motorLeftFront = new TalonSRX(CANConstants.LEFT_FRONT_DRIVE_TALON);
        motorLeftBack = new TalonSRX(CANConstants.LEFT_BACK_DRIVE_TALON);
        motorRightFront = new TalonSRX(CANConstants.RIGHT_FRONT_DRIVE_TALON);
        motorRightBack = new TalonSRX(CANConstants.RIGHT_BACK_DRIVE_TALON);
        initMotorControllers();
        initInputs();
        
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        motor.set(ControlMode.PercentOutput, speed);
    }

    // respond to input updates
    public void inputUpdate(Input source) {
        // check to see which input was updated
        //if (signal == joystick) {
         //   speed = joystick.getValue();
        //}
        if (source == throttleInput) {
            setThrottle(-throttleInput.getValue());
        } else if (source == headingInput) {
            setHeading(-headingInput.getValue());
        } 
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