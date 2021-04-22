package org.wildstang.year2021.robot;

/**
 * CAN Constants are stored here.
 * We primarily use CAN to communicate with Talon motor controllers.
 * These constants must correlate with the IDs set in Phoenix Tuner.
 * Official documentation can be found here:
 * https://phoenix-documentation.readthedocs.io/en/latest/ch08_BringUpCAN.html
 */
public final class CANConstants {

    // Drive CAN constant are good
    public static final int LEFT_DRIVE_VICTOR_FRONT = 1;
    public static final int LEFT_DRIVE_TALON_BACK = 2;
    public static final int RIGHT_DRIVE_VICTOR_FRONT = 3;
    public static final int RIGHT_DRIVE_TALON_BACK = 4;
    // Manipulator CAN constants are not good
    public static final int ARM_VICTOR = 5;
    public static final int HOPPER_VICTOR = 6;
    public static final int INTAKE_ROLLER_VICTOR = 7;
    //public static final int INTAKE_LIFT_VICTOR = 8;
    
    public static final int EXAMPLE_CONTROLLER = 1;
    public static final int[] EXAMPLE_PAIRED_CONTROLLERS = {2,3};
}