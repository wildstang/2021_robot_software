package org.wildstang.year2021.robot;

/**
 * CAN Constants are stored here.
 * We primarily use CAN to communicate with Talon motor controllers.
 * These constants must correlate with the IDs set in Phoenix Tuner.
 * Official documentation can be found here:
 * https://phoenix-documentation.readthedocs.io/en/latest/ch08_BringUpCAN.html
 */
public final class CANConstants {

    public static final int LeftDriveTalon = 1; 
    public static final int RightDriveTalon = 2; 
    public static final int CenterDriveTalon1 = 3;
    public static final int CenterDriveTalon2 = 4; 
    public static final int Intake = 5;
    public static final int IntakeDeplay = 6;  
    public static final int HighFuel = 7; 
    public static final int Descoring = 8; 
    
}