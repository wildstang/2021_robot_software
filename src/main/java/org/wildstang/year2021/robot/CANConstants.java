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
    public static final int INTAKE_VICTOR = 20;

    public static final int[] EXAMPLE_PAIRED_CONTROLLERS = {2,3};

    public static final int DRIVE1 = 10;//front left
    public static final int ANGLE1 = 11;
    public static final int DRIVE2 = 12;//front right
    public static final int ANGLE2 = 13;
    public static final int DRIVE3 = 16;//rear left
    public static final int ANGLE3 = 17;
    public static final int DRIVE4 = 14;//rear right
    public static final int ANGLE4 = 15;

    public static final int ENC1 = 31;//front left
    public static final int ENC2 = 32;//front right
    public static final int ENC3 = 33;//rear left
    public static final int ENC4 = 34;//rear right
    
}