package frc.team3100.robot.Wall;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxStates;

public class WallExtend extends Command {

    public WallExtend(){
        super("WallExtend");
    }



    protected void initialize(){

   //     if(RobotMap.driveControls.getRightBumper()){

     //       RobotMap.wallPiston.set(true);

     //   }else{

      //      RobotMap.wallPiston.set(false);

    //    }


    }

    protected void execute() {

        if(RobotMap.driveControls.getRightBumper()){

            RobotMap.wallPiston.set(true);

        }else{

            RobotMap.wallPiston.set(false);

        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
