package org.wildstang.year2021.subsystems;
 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
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
 * Class:       Intake.java
 * Inputs:      3 digital buttons
 * Outputs:     2 victors
 * Description: This controls the ball elevator with 3 speeds (reverse, 0, and fullspeed) and controls the back hatch. 
 */

public class Ballpath implements Subsystem {

    //Inputs
    private DigitalInput leftShoulder; // Left Shoulder Button
    private DigitalInput rightShoulder; // Right Shoulder Button
    private DigitalInput reverseButton; // Diver Face Up Button

    //Outputs
    private VictorSPX intakeMotor;
    private VictorSPX outputMotor;

    //Motor Speeds
    private double intakeMotorSpeed;
    private double outputMotorSpeed;
    
    //Constants
    private final double FULL_SPEED = 1;
    private final double HALF_SPEED = 0.5;
    private final double REVERSE_SPEED = 1;
    private final double hatchMoveTime = 10;

    //Booleans
    private boolean timerStatus;

    //Timer
    private WsTimer timer = new WsTimer();


    enum commands {
            IDLE, RAISING, RAISED, PAUSED, LOWERING, LOWERED, RESET;
    }
    private commands currentCommand; // 0 = IDLE x
                                     // 1 = RAISING x
                                     // 2 = RAISED /
                                     // 3 = PAUSED /
                                     // 4 = LOWERING /
                                     // 5 = LOWERED /
                                     // 7 = RESET


    // initializes the subsystem
    public void init() {
        // register button and attach input listener with WS Input
        leftShoulder = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_SHOULDER_LEFT.getName());
        leftShoulder.addInputListener(this);
        rightShoulder = (DigitalInput) Core.getInputManager().getInput(WSInputs.DRIVER_SHOULDER_RIGHT.getName());
        rightShoulder.addInputListener(this);    

        // create motor controller object with CAN Constant
        intakeMotor = new VictorSPX(CANConstants.INTAKE_MOTOR);
        outputMotor = new VictorSPX(CANConstants.OUTPUT_MOTOR);

        timer.start();
        resetState();
    }

    // update the subsystem everytime the framework updates (every ~0.02 seconds)
    public void update() {
        intakeMotor.set(ControlMode.PercentOutput, intakeMotorSpeed);
        outputMotor.set(ControlMode.PercentOutput, outputMotorSpeed);


        

        // Begin  from Idle -> Raising -> Paused
        if (currentCommand == commands.RAISING) {
            if (!timerStatus) {
                timer.reset();
                timer.start();
                timerStatus = true;
                outputMotorSpeed = -HALF_SPEED;
            } else if (timer.hasPeriodPassed(hatchMoveTime)) {
                currentCommand = commands.PAUSED;
            }
        }
        if (currentCommand == commands.PAUSED) {
            outputMotorSpeed = 0;
            timerStatus = false;
        }

        // Change  from Lowering -> Reset -> Idle
        if (currentCommand == commands.LOWERING) {
            if (!timerStatus) {
                timer.reset();
                timer.start();
                timerStatus = true;
                outputMotorSpeed = HALF_SPEED;
            } else if (timer.hasPeriodPassed(hatchMoveTime)) {
                currentCommand = commands.RESET;
            }
        }

        if (currentCommand == commands.RESET) {
            outputMotorSpeed = 0;
            timerStatus = false; 
            currentCommand = commands.IDLE;
        }
          
    }

    // respond to input updates
    public void inputUpdate(Input signal) {
        // check to see which input was updated

        if (rightShoulder.getValue()) {
            intakeMotorSpeed = FULL_SPEED;
        } else if (reverseButton.getValue()) { 
            intakeMotorSpeed = REVERSE_SPEED;
        } else {
            intakeMotorSpeed = 0;
        }

        if (currentCommand == commands.IDLE && leftShoulder.getValue()) {
            currentCommand = commands.RAISING;
        } else if (currentCommand == commands.PAUSED && leftShoulder.getValue()) {
            currentCommand = commands.LOWERING;
        }

    }

    // used for testing
    public void selfTest() {

    }

    // resets all variables to the default state
    public void resetState() {
        intakeMotorSpeed = 0;
        outputMotorSpeed = 0;
        timerStatus = false;
        currentCommand = commands.IDLE;

    }

    // returns the unique name of the example
    public String getName() {
        return "Ballpath Subsystem";
    }
}