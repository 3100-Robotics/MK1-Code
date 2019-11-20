package frc.team3100.robot.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;

import static frc.team3100.robot.RobotMap.leftDriveMotor;
import static frc.team3100.robot.RobotMap.rightDriveMotor;


public class Drive extends Subsystem {

     DifferentialDrive differentialDrive = null;


    private double limitSpeed = 1;
    private double limitRotate = 1;

    public int storedValLeft = 0;
    public int storedValRight = 0;

    public Drive() {
        super("Drive");

        differentialDrive = new DifferentialDrive(leftDriveMotor, rightDriveMotor);
    }

    //Arcade Drive, one Joystick controls forwards/backwards, the other controls turning
    public void arcadeDrive(double moveSpeed, double rotateSpeed) {


       // DriverStation ds = DriverStation.getInstance();
       // double time = ds.getMatchTime();
       // System.out.println(time);
       // SmartDashboard.putNumber("Time", time);

        //Limits for speed, using quadratics and max/min
        moveSpeed = deadband(moveSpeed);
        rotateSpeed = deadband(rotateSpeed);

        limitSpeed = moveSpeed < 0 ? -0.9 : 0.9;
        limitRotate = rotateSpeed < 0 ? -0.8 : 0.8;

        moveSpeed *= limitSpeed * moveSpeed;
        rotateSpeed *= limitRotate * rotateSpeed;

        moveSpeed = Math.pow(moveSpeed, 3);

        //Tells the program to run the driveArcade
        differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);


    }
    //Tank Drive, one Joystick controls the left, one controls the right.
    public void tankDrive(double leftSpeed, double rightSpeed) {


        leftSpeed = deadband(leftSpeed);
        rightSpeed = deadband(rightSpeed);

        limitSpeed = leftSpeed < 0 ? -0.8 : 0.8;
        limitRotate = rightSpeed < 0 ? -0.8 : 0.8;

        leftSpeed *= limitSpeed * leftSpeed;
        rightSpeed *= limitRotate * rightSpeed;

//        differentialDrive.tankDrive(leftSpeed, rightSpeed);

    }

    //The command won't work if you only bump the stick a little, a deadband in the middle
    private double deadband(double input) {
        if (Math.abs(input) < 0.2) {
            return 0;
        } else {
            return input;
        }
    }

    //Sets the default on startup command to be DriveMotion
    public void initDefaultCommand() {
        setDefaultCommand(new DriveMotion());
    }

}