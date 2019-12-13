package frc.team3100.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;

public class dooblePiston extends Command {



    public dooblePiston() {
        super("DoublePistonExtend");
    }



    protected void initialize() {

    }

    //Testing command to run pneumatics
    protected void execute() {

        //Setting piston to extend

        RobotMap.wallPiston.set(true);
        RobotMap.secondPiston.set(true);

    }

    @Override
    protected void interrupted() {

        //Setting piston to retract
        RobotMap.wallPiston.set(false);
        RobotMap.secondPiston.set(false);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}

