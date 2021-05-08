package org.wildstang.year2021.robot;

import org.wildstang.year2021.subsystems.drive.TankDrive;
import org.wildstang.year2021.subsystems.arm.Arm;
import org.wildstang.year2021.subsystems.hopper.Hopper;
import org.wildstang.year2021.subsystems.intake.Intake;
import org.wildstang.framework.core.Subsystems;

/**
 * All subsystems are enumerated here.
 * It is used in Robot.java to initialize all subsystems.
 */
public enum WSSubsystems implements Subsystems {

    // enumerate subsystems
    TANKDRIVE("Tank Drive", TankDrive.class),
    ARM("Arm", Arm.class),
    HOPPER("Hopper", Hopper.class),
    INTAKE("Intake", Intake.class);
    
    private String name;
    private Class<?> subsystemClass;

    WSSubsystems(String name, Class<?> subsystemClass) {
        this.name = name;
        this.subsystemClass = subsystemClass;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?> getSubsystemClass() {
        return subsystemClass;
    }
}