package org.wildstang.year2021.subsystems;

import org.wildstang.year2021.robot.CANConstants;
import org.wildstang.year2021.robot.WSInputs;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.networktables.NetworkTableEntry;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
public class Intake implements Subsystem {

    // inputs
    private AnalogInput out;
    private AnalogInput in;
    private AnalogInput manipOut;
    private AnalogInput manipIn;

    // outputs
    private VictorSPX motor;
    private VictorSPX hopperMotor;

    // states
    private double speed;
    private double hopperSpeed;
    private final double maxSpeed = 0.75;

    private ShuffleboardTab intakeTab;
    private NetworkTableEntry intakeMaxSpeed;
    private NetworkTableEntry hopperMaxSpeed;

    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        //out = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_TRIGGER_LEFT.getName());
        in = (AnalogInput) Core.getInputManager().getInput(WSInputs.DRIVER_TRIGGER_RIGHT.getName());
        //out.addInputListener(this);
        in.addInputListener(this);

        manipOut = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_TRIGGER_LEFT.getName());
        manipIn = (AnalogInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_TRIGGER_RIGHT.getName());
        manipOut.addInputListener(this);
        manipIn.addInputListener(this);

        // create motor controller object with CAN Constant
      
        speed = 0;

       intakeTab = Shuffleboard.getTab("Intake Tab");
       intakeMaxSpeed = intakeTab.add("Intake Max Speed", 0.017).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -0.1, "max", 0.1)).getEntry();
       hopperMaxSpeed = intakeTab.add("Hopper Max Speed", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 1)).getEntry();

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
        if (signal == manipOut && manipOut.getValue() >0.25) {
            speed = -maxSpeed;
            hopperSpeed = 0;
        }else if((signal == in && in.getValue() < -0.25) || (signal == manipIn && manipIn.getValue() < -0.25)){
            speed = maxSpeed;
            hopperSpeed = 0.5;
        }else{
            speed = 0;
            hopperSpeed = 0;
        }
    }
    
    public void turnOnIntake(){
        speed = 1;
    }

     public void intakeOff(){
        speed = 0;
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