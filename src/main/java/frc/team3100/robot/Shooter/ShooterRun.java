package frc.team3100.robot.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;

//DriveMotion is a command that is used to run the drivetrain
public class ShooterRun extends Command {


    public ShooterRun() {
        super("ShooterRun");
        requires(Robot.shooter);

    }

    @Override
    protected void initialize() {


    }

    @Override
    protected void execute() {

            Robot.shooter.run();
            RobotMap.leftDriveMotor.set(ControlMode.Velocity, 0.9 * 500.0 * 4096.0 / 600.0);
        SmartDashboard.putNumber("Speed", RobotMap.leftDriveMotor.getSelectedSensorVelocity(0));

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


