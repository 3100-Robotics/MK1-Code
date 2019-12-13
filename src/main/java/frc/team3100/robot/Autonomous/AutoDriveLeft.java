package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

import static frc.team3100.robot.Robot.drive;

public class AutoDriveLeft extends Command {

    private double endTime;
    private double driveTime;

    private double time;
    private double currentTime;

    boolean stop = false;

    //Constructor for AutoDrive, takes in the drive subsystem, and sets up driveTime to take in seconds
    public AutoDriveLeft(double seconds) {
        super("AutoDriveForward");
        requires(drive);
        driveTime = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        time -= DriverStation.getInstance().getMatchTime();
        currentTime = (time * 20) / 1000;
        endTime = currentTime + driveTime;


    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        time -= DriverStation.getInstance().getMatchTime();
        currentTime = (time * 20) / 1000;
        System.out.println(currentTime);

        //Asking if you want the robot in Tank Drive or Arcade Drive
        if (Robot.mode == 1) {
            if(endTime > currentTime) {
                drive.arcadeDrive(0, 1);
            } else {
                stop = true;
                System.out.println("Done Driving Forward");
            }

        } else if (Robot.mode == 2) {
            if(currentTime > endTime) {
                drive.tankDrive(-1, 1);
            }else {
                stop = true;
                System.out.println("Done Driving Left");
            }
        }else{
            System.out.println("No Mode Selected");
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stop == true;
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
