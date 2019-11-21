package frc.team3100.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxStates;

public class WallExtend extends Command {



    public WallExtend() {
        super("WallExtend");
    }



    protected void initialize() {

    }

    //Testing command to run pneumatics
    protected void execute() {

            RobotMap.wallPiston.set(true);

    }

    @Override
    protected void interrupted() {

            RobotMap.wallPiston.set(false);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
