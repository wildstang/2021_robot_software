package org.wildstang.year2021.robot;

import org.wildstang.year2021.subsystems.TestSubsystem;
<<<<<<< HEAD
import org.wildstang.year2021.subsystems.SwerveDrive;
=======
import org.wildstang.year2021.subsystems.Intake;
>>>>>>> 111/IR-at-home/Ethan
import org.wildstang.framework.core.Subsystems;

/**
 * All subsystems are enumerated here.
 * It is used in Robot.java to initialize all subsystems.
 */
public enum WSSubsystems implements Subsystems {

    // enumerate subsystems
<<<<<<< HEAD
    SwerveDrive("Swerve Drive", SwerveDrive.class);
    //TEST("Test Subsystem", TestSubsystem.class);
=======
    TEST("Test Subsystem", TestSubsystem.class),
    INTAKE("Intake", Intake.class);
>>>>>>> 111/IR-at-home/Ethan
    
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