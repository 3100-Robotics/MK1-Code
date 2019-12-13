package frc.team3100.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;

import static frc.team3100.robot.Robot.drive;

public class MoveBackwards extends Command {

    int time = 0;
    int currentTime;



    protected void initialize() {

        currentTime = (time * 20) / 1000;

    }


    protected void execute() {

        if (RobotMap.techControls.getButtonA()) {

            //Sets the motors to specific speeds
            if(Robot.mode == 1){
                if(time > 50) {
                    drive.arcadeDrive(1, 0);
                    time += 1;
                }

            }else if(Robot.mode == 2){

                drive.tankDrive(1,1);
                RobotMap.leftDriveMotor.setExpiration(1);
                RobotMap.rightDriveMotor.setExpiration(1);

            }

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
