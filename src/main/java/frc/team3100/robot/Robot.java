package frc.team3100.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Autonomous.AutonomousMaster;
import frc.team3100.robot.Drivetrain.Drive;
import frc.team3100.robot.Drivetrain.DriveMotion;
import frc.team3100.robot.Commands.WallExtend;

import static edu.wpi.first.wpilibj.Timer.getMatchTime;



public class Robot extends TimedRobot {


    public static double time = Timer.getMatchTime();


       // public static double time = 0;

    //If mode = 1, Arcade
    //If mode = 2, Tank
    public static int mode = 1;

    public static OI oi;
    public static Drive drive;
  //  public static WallExtend wallextend;



    private Command autonomousCommand;
    private SendableChooser<Command> chooser = new SendableChooser<>();

    @Override
    public void robotInit() {

        drive = new Drive();
     //   wallextend = new WallExtend();


        autonomousCommand = new AutonomousMaster();
        // ALWAYS INIT OI LAST
        oi = new OI();

        chooser.setDefaultOption("Auto Master", new AutonomousMaster());
        chooser.addOption("Teleop Drive", new DriveMotion());
        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }


    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();

        time = DriverStation.getInstance().getMatchTime();
        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */


        // schedule the autonomous command (example)
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {

        time = DriverStation.getInstance().getMatchTime();
        SmartDashboard.putNumber("Time", Robot.time);
        System.out.println(time);

        Scheduler.getInstance().run();

    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {

    }
}

