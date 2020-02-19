package org.wildstang.year2020.subsystems.climb;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import org.wildstang.framework.core.Core;
import org.wildstang.framework.io.IInputManager;
import org.wildstang.framework.io.Input;
import org.wildstang.framework.io.inputs.DigitalInput;
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.year2020.robot.CANConstants;
import org.wildstang.year2020.robot.WSInputs;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climb implements Subsystem {

    // Inputs
    private DigitalInput selectButton;
    private DigitalInput startButton;
    private DigitalInput downButton;

    // Outputs
    private CANSparkMax climbMotor1;
    private CANSparkMax climbMotor2;

    // Variables
    private final double MOTOR_SPEED = 0.3;
    private final double LIFT_HEIGHT = -55;
    private final double LIFT_BOTTOM = -0.5;

    // Statuses
    private boolean climbInputStatus;
    private boolean climbActiveStatus; // For Shuffleboard
    private boolean climbCompleteStatus;
    private boolean downPressed;

    @Override
    public void inputUpdate(Input source) {
        if (selectButton.getValue() && startButton.getValue()) {
            climbInputStatus = true;
        }
        else {
            climbInputStatus = false;
        }

        if (downButton.getValue()) {
            downPressed = true;
        } else {
            downPressed = false;
        }
    }

    @Override
    public void init() {
        initInputs();
        initOutputs();
        resetState();
    }

    @Override
    public void selfTest() {
    }

    @Override
    public void update() {
         // If button is pressed, set the motorspeed to the defined value in the inputUpdate method
        if (climbInputStatus) {
            climbActiveStatus = true; // For Shuffleboard
            climbMotor1.set(MOTOR_SPEED);
            climbMotor2.set(MOTOR_SPEED);
        }

        if (climbActiveStatus && !climbCompleteStatus && climbMotor1.getEncoder().getPosition() >= LIFT_HEIGHT && climbMotor2.getEncoder().getPosition() >= LIFT_HEIGHT) {
            climbActiveStatus = false;
            climbCompleteStatus = true;
        }

        SmartDashboard.putBoolean("Climb started",climbInputStatus);
        if (climbCompleteStatus == true && downPressed == true) {
            climbActiveStatus = true;
            climbMotor1.set(MOTOR_SPEED);
            climbMotor2.set(MOTOR_SPEED);
        }
        // If anything else, set motorspeed to 0
        if (climbCompleteStatus == true && downPressed == false) {
            climbActiveStatus = false; // For Shuffleboard
            climbMotor1.set(0);
            climbMotor2.set(0);
        }
        
        SmartDashboard.putNumber("Climb Motor 1 Encoder",climbMotor1.getEncoder().getPosition());
        SmartDashboard.putNumber("Climb Motor 2 Encoder",climbMotor2.getEncoder().getPosition());
    }

    @Override
    public void resetState() {
        climbInputStatus = false;
        climbActiveStatus = false;
        climbCompleteStatus = false;
        //climbMotor1.restoreFactoryDefaults();
        //climbMotor2.restoreFactoryDefaults();
    }

    @Override
    public String getName() {
        return "Climb";
    }

    private void initOutputs() {
        climbMotor1 = new CANSparkMax(CANConstants.CLIMB_VICTOR_1,MotorType.kBrushless);
        climbMotor2 = new CANSparkMax(CANConstants.CLIMB_VICTOR_2,MotorType.kBrushless);
    }

    private void initInputs() {
        IInputManager inputManager = Core.getInputManager();
        selectButton = (DigitalInput) inputManager.getInput(WSInputs.MANIPULATOR_SELECT.getName());
        selectButton.addInputListener(this);
        startButton = (DigitalInput) inputManager.getInput(WSInputs.MANIPULATOR_START.getName());
        startButton.addInputListener(this);
        downButton = (DigitalInput) inputManager.getInput(WSInputs.MANIPULATOR_DPAD_DOWN.getName());
        downButton.addInputListener(this);
    }

}