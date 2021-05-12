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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Class:       Ballpath.java
 * Inputs:      3 digital buttons
 * Outputs:     2 victors
 * Description: This controls the ball elevator w/ the right shoulder & top face-button, & controls the back hatch w/ the left shoulder. 
 */

public class Ballpath implements Subsystem {

    //Inputs
    private DigitalInput leftShoulder; // Left Shoulder Button
    private DigitalInput rightShoulder; // Right Shoulder Button
    private DigitalInput reverseButton; // Diver Face Up Button
    private DigitalInput dpadLeftButton; // Diver D-pad Button left

    //Outputs
    private VictorSPX intakeMotor;
    private VictorSPX outputMotor;

    //Motor Speeds
    private double intakeMotorSpeed;
    private double outputMotorSpeed;
    
    //Constants
    private final double FULL_SPEED = .5; //1
    private final double REVERSE_SPEED = -.5;
    private final double HATCH_OPEN_SPEED = 0.5; //.25
    private final double HATCH_CLOSE_SPEED = -0.4;
    private final double HATCH_MOVE_TIME = .75; //1
    private final double RESET_TIME = 1.35; //1
    

    //Booleans
    private boolean timerStatus;
    private boolean calStatus;
    private boolean hatchCalabration;
    private boolean running;

    //Timer
    private WsTimer timer = new WsTimer();
    private WsTimer calTimer = new WsTimer(); //calibration timer


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
        leftShoulder = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_LEFT_SHOULDER.getName());
        leftShoulder.addInputListener(this);
        rightShoulder = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_RIGHT_SHOULDER.getName());
        rightShoulder.addInputListener(this);    
        reverseButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_FACE_UP.getName());
        reverseButton.addInputListener(this);
        dpadLeftButton = (DigitalInput) Core.getInputManager().getInput(WSInputs.MANIPULATOR_DPAD_LEFT.getName());
        dpadLeftButton.addInputListener(this);

        // create motor controller object with CAN Constant
        intakeMotor = new VictorSPX(CANConstants.INTAKE_MOTOR);
        outputMotor = new VictorSPX(CANConstants.OUTPUT_MOTOR);

        timer.start();
        calTimer.start();
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
                outputMotorSpeed = HATCH_OPEN_SPEED;
            } else if (timer.hasPeriodPassed(HATCH_MOVE_TIME)) {
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
                outputMotorSpeed = HATCH_CLOSE_SPEED;
            } else if (timer.hasPeriodPassed(HATCH_MOVE_TIME)) {
                currentCommand = commands.RESET;
            }
        }

        if (currentCommand == commands.RESET) {
            outputMotorSpeed = 0;
            timerStatus = false; 
            currentCommand = commands.IDLE;
        }
          

        if (hatchCalabration) { //while you hold left dpad
            outputMotorSpeed = HATCH_OPEN_SPEED; //lift 
            running = true;
        } else if (running && !hatchCalabration) { //auto reset
            outputMotorSpeed = HATCH_CLOSE_SPEED;
            if (calStatus == false) {
                calTimer.reset();
                calTimer.start();
                calStatus = true;
            } else if (calTimer.hasPeriodPassed(RESET_TIME)) {
                running = false;
            }
        } else {
            outputMotorSpeed = 0;
            running = false;
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

        if (currentCommand == commands.IDLE && leftShoulder.getValue() && signal == leftShoulder) {
            currentCommand = commands.RAISING;
        } else if (currentCommand == commands.PAUSED && leftShoulder.getValue() && signal == leftShoulder) {
            currentCommand = commands.LOWERING;
        }

        if (dpadLeftButton.getValue()) {
            hatchCalabration = true;
        } else {
            hatchCalabration = false;
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
        calStatus = false;
        hatchCalabration = false;
        running = false;
        currentCommand = commands.IDLE;

    }

    // returns the unique name of the example
    public String getName() {
        return "Ballpath";
    }

    public void ballpathDeploy(){
        intakeMotorSpeed = REVERSE_SPEED;
    }
    public void turnOffBallpath(){
        intakeMotorSpeed = 0;
    }
    public void turnOnBallpath(){
        intakeMotorSpeed = FULL_SPEED;
    }
    public void openHatch(){
        currentCommand = commands.RAISING;
    }
    public void closeHatch(){
        currentCommand = commands.LOWERING;
    }

    


}