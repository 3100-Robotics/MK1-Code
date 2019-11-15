package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;


public class DriveMotion extends Command {
    public DriveMotion() {
        super("DriveMotion");
        requires(Robot.drive);

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {


            if (Robot.mode == 1) {
                //Arcade Drive
                Robot.drive.arcadeDrive(RobotMap.driveControls.getLeftStickY(), -RobotMap.driveControls.getRightStickX());
            }


            else if (Robot.mode == 2) {
                //Tank Drive
                Robot.drive.tankDrive(RobotMap.driveControls.getLeftStickY(), RobotMap.driveControls.getRightStickY());

        }
    }


    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}


