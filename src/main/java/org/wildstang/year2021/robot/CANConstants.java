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

    public static final int DRIVE1 = 10;
    public static final int ANGLE1 = 11;
    public static final int DRIVE2 = 12;
    public static final int ANGLE2 = 13;
    public static final int DRIVE3 = 14;
    public static final int ANGLE3 = 15;
    public static final int DRIVE4 = 16;
    public static final int ANGLE4 = 17;

    public static final int ENC1 = 30;
    public static final int ENC2 = 31;
    public static final int ENC3 = 32;
    public static final int ENC4 = 33;
    
}