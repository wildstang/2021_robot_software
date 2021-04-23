package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;

/**
 * Class:       TestSubsystem.java
 * Inputs:      1 joystick
 * Outputs:     1 talon
 * Description: This is a testing subsystem that controls a single motor with a joystick.
 */
public class Intake implements Subsystem {

    // inputs
    private DigitalInput out;
    private DigitalInput in;

    // outputs
    private VictorSPX motor;
    private VictorSPX hopperMotor;

    // states
    private double speed;
    private double hopperSpeed;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        out = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_DOWN.getName());
        in = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_FACE_RIGHT.getName());
        out.addInputListener(this);
        in.addInputListener(this);

        // create motor controller object with CAN Constant
      
        speed = 0;

        motor = new VictorSPX(CANConstants.INTAKE_TALON);
        hopperMotor = new VictorSPX(CANConstants.HOPPER_TALON);
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        SmartDashboard.putNumber("Intake Speed", speed);
        SmartDashboard.putNumber("Hopper Speed", hopperSpeed);
        motor.set(ControlMode.PercentOutput, speed);
        hopperMotor.set(ControlMode.PercentOutput, hopperSpeed);
        //System.out.println(speed);
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated
        if (signal == out && out.getValue()) {
            speed = 1;
            hopperSpeed = 1;
        }else if(signal == in && in.getValue()){
            speed = -1;
            hopperSpeed = 1;
        }else{
            speed = 0;
            hopperSpeed = 0;
        }
    }
    
    public void turnOnIntake(){
        speed = 1;
    }

     public void intakeOff(){
        hopperSpeed = 0;
    }
    
    public void turnOnHopper(){
        hopperSpeed = 1;
    }

     public void hopperOff(){
        hopperSpeed = 0;
    }

    // used for testing
    public void selfTest() {}

    // resets all variables to the default state
    public void resetState() {
        speed = 0.0;
    }

    // returns the unique name of the example
    public String getName() {
        return "Intake";
    }
}