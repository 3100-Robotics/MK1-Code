package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMaster extends CommandGroup {

    //Master grouping for all of the autonomous commands
    public AutonomousMaster(){

        //addSequential(new AutoDriveForward());
        //addSequential(new AutoDriveBackward());
        //addSequential(new AutoDriveLeft());
        //addSequential(new AutoDriveRight());

            addSequential(new AutoDriveForward(1));
        addSequential(new AutoDriveLeft(2));
        addSequential(new AutoDriveForward(4));
        addSequential(new AutoDriveRight(2));
    }

}
