package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

import static frc.team3100.robot.Robot.drive;

public class DriveStraightForXAtY extends Command {
    protected double power;
    protected double time;
    protected double endTime;
    protected int currentTime = (int) System.currentTimeMillis();

    public DriveStraightForXAtY(double power, double timeInMillis) {
        this.power = power;
        this.time = timeInMillis;
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        long startTime = System.currentTimeMillis();
        endTime = startTime + this.time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.arcadeDrive(power, power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return currentTime >= endTime;

    }

    // Called once after isFinished returns true
    protected void end() {

        drive.arcadeDrive(0, 0);

    }

    protected void interrupted() {
        end();
    }
}