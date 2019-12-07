package frc.team3100.robot.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Autonomous.AutoDriveForward;
import frc.team3100.robot.RobotMap;

//Each Groups Individual Code
public class Group1 extends CommandGroup {

    public Group1() {
        super("Group1");

        //Auton code goes here

    }



    protected void initialize() {

    }

    //Testing command to run pneumatics
    protected void execute() {

        if (RobotMap.techControls.getButtonY()) {

            RobotMap.auxMotor.set(0.2);
            RobotMap.auxMotor2.set(0.2);

        }else {

            RobotMap.auxMotor.set(0);
            RobotMap.auxMotor2.set(0);

        }

    }

    @Override
    protected void interrupted() {



    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}

