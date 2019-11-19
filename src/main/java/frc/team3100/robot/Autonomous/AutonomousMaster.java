package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMaster extends CommandGroup {

    //Master grouping for all of the autonomous commands
    public AutonomousMaster(){

            addSequential(new AutoDrive());

    }

}
