package org.wildstang.year2021.robot;

/**
 * CAN Constants are stored here.
 * We primarily use CAN to communicate with Talon motor controllers.
 * These constants must correlate with the IDs set in Phoenix Tuner.
 * Official documentation can be found here:
 * https://phoenix-documentation.readthedocs.io/en/latest/ch08_BringUpCAN.html
 */
public final class CANConstants {

    public static final int EXAMPLE_CONTROLLER = 1;
    public static final int[] EXAMPLE_PAIRED_CONTROLLERS = {2,3};

    public static final int LEFT_BACK_DRIVE_TALON = 2;
    public static final int LEFT_FRONT_DRIVE_TALON = 1;
    public static final int RIGHT_BACK_DRIVE_TALON = 4;
    public static final int RIGHT_FRONT_DRIVE_TALON = 3;
    public static final int INTAKE_TALON = 5;
    public static final int HOPPER_TALON = 6;
    //Define motors here
    
}