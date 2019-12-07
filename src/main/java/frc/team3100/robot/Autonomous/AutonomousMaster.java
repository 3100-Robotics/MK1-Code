package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Robot;

public class AutonomousMaster extends CommandGroup {

    //Master grouping for all of the autonomous commands, used to sequence the commands in order
    public AutonomousMaster(Character selected){
        super("AutonomousMaster");
        requires(Robot.drive);

        //addSequential(new AutoDriveForward());

        //addSequential(new AutoDriveBackward());

        //addSequential(new AutoDriveLeft());

        //addSequential(new AutoDriveRight());

        System.out.println("Test");



        addSequential(new AutoDriveForward(2));
        addSequential(new AutoDriveLeft(2));
       // addSequential(new AutoDriveForward(4));
      //  addSequential(new AutoDriveRight(2));
    }

}
