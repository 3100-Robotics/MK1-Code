package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMaster extends CommandGroup {

    public AutonomousMaster(){

            addSequential(new AutoDrive());

    }

}
