package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

import static frc.team3100.robot.Robot.drive;

public class AutoDriveForward extends Command {

    private double endTime;
    private double driveTime;

    private double time;
    private double currentTime;

    boolean stop = false;

    //Constructor for AutoDrive, takes in the drive subsystem, and sets up driveTime to take in seconds
    public AutoDriveForward(double seconds) {
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
      //  System.out.println(time2);

        //Asking if you want the robot in Tank Drive or Arcade Drive
        if (Robot.mode == 1) {
            if(currentTime < endTime) {
               drive.arcadeDrive(1, 0);
            } else {
                stop = true;
                System.out.println("Done Driving Forward");
            }

        } else if (Robot.mode == 2) {
            if(currentTime < endTime) {
                drive.tankDrive(1, 1);
            }else {
                stop = true;
                System.out.println("Done Driving Forward");
            }
        }else{
            System.out.println("No Mode Selected");
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
            if(stop == true){
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
