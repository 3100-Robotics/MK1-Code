package frc.team3100.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Drivetrain.Drive;
import frc.team3100.robot.OI;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;

import static frc.team3100.robot.Robot.drive;


public class MotorRun extends Command {

    protected void initialize() {

    }

    //Testing command to run motors
    protected void execute() {

        //Big file to use motors
        if (RobotMap.techControls.getButtonB()) {

            //Sets the motors to specific speeds
            RobotMap.auxMotor.set(-0.35); //Top Motor 0.35
            RobotMap.auxMotor2.set(-1); //Bottom Motor 1


        }else if(RobotMap.techControls.getButtonX()) {

            RobotMap.auxMotor.set(0.4);
            RobotMap.auxMotor2.set(0.4);


        }else if (RobotMap.techControls.getButtonY()) {

            //Sets the motors to specific speeds
            RobotMap.auxMotor.set(-0.7);//Top
            RobotMap.auxMotor2.set(-0.4);//Bottom

        }else if (RobotMap.techControls.getLeftBumper()){

            RobotMap.auxMotor.set(-1);
            RobotMap.auxMotor2.set(-1);

        }else {

            //Tells the motors not to run if they're on activated
            RobotMap.auxMotor.set(0);
            RobotMap.auxMotor2.set(0);

        }

    }

    protected void end() {

        RobotMap.auxMotor.set(0);
        RobotMap.auxMotor2.set(0);

    }

    protected void interrupted() {
        end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
