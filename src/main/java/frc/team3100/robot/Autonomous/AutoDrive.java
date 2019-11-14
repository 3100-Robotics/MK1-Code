package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

import static frc.team3100.robot.Robot.drive;

public class AutoDrive extends Command {





    public AutoDrive() {
        super("AutoDrive");
        requires(drive);
        SmartDashboard.putNumber("Time", Robot.time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

                drive.arcadeDrive(1, 0);
                Robot.time += 1;

   }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.time > 100){
            return true;
        }else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }


}
