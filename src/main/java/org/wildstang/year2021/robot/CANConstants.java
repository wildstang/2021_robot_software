package org.wildstang.year2021.robot;

/**
 * CAN Constants are stored here.
 * We primarily use CAN to communicate with Talon motor controllers.
 * These constants must correlate with the IDs set in Phoenix Tuner.
 * Official documentation can be found here:
 * https://phoenix-documentation.readthedocs.io/en/latest/ch08_BringUpCAN.html
 */
public final class CANConstants {

    public static final int DRIVE_LEFT = 2;
    public static final int DRIVE_RIGHT = 3;
    public static final int INTAKE_MOTOR = 6;
    public static final int OUTPUT_MOTOR = 4;
    public static final int HIGHBALL_MOTOR = 5;

    //public static final int EXAMPLE_CONTROLLER = 1;
    //public static final int[] EXAMPLE_PAIRED_CONTROLLERS = {2,3};
    
}