package org.wildstang.year2021.robot;

import org.wildstang.year2021.subsystems.Drivebase;
import org.wildstang.year2021.subsystems.Intake;
import org.wildstang.year2021.subsystems.Hopper;
import org.wildstang.framework.core.Subsystems;

/**
 * All subsystems are enumerated here.
 * It is used in Robot.java to initialize all subsystems.
 */
public enum WSSubsystems implements Subsystems {

    // enumerate subsystems
    DRIVEBASE("Drive Base", Drivebase.class);
    //INTAKE("Intake", Intake.class),
    //HOPPER("Hopper", Hopper.class);
    
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