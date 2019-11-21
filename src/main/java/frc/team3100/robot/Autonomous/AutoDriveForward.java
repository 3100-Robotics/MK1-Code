package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

import static frc.team3100.robot.Robot.drive;

public class AutoDriveForward extends Command {

    protected double endTime;
    double driveTime;
    boolean stop = false;

    //Constructor for AutoDrive, takes in the drive subsystem and writes a time to the smartdashboard
    public AutoDriveForward(double seconds) {
        super("AutoDriveForward");
        requires(drive);
        driveTime = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        endTime = Timer.getMatchTime() + driveTime;
        //System.out.println(endTime);
   //     System.out.println(driveTime);
        System.out.println("Test");

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {


        if (Robot.mode == 1) {
            if(Timer.getMatchTime() < endTime) {
                drive.arcadeDrive(1, 0);
                stop = true;
            }

        } else if (Robot.mode == 2) {
            if(Robot.time < endTime) {
                drive.tankDrive(1, 1);
                stop = true;
            }
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (stop == true) {
            return true;
        } else {
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
