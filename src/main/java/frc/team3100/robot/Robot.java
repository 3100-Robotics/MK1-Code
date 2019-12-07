package frc.team3100.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Autonomous.AutonomousMaster;
import frc.team3100.robot.Drivetrain.Drive;
import frc.team3100.robot.Drivetrain.DriveMotion;
//Group Functions
//Calls a calls that has everything the group has control over, defines the group


@SuppressWarnings("ALL")
public class Robot extends TimedRobot {


    //If mode = 1, Arcade
    //If mode = 2, Tank
    public static int mode = 1;


    public static OI oi;
    public static Drive drive;

    public double pi;
    private boolean ran = false;


    public static String gameData;
    private Command autonomousCommand;
    private SendableChooser<Character> autoSide;
    private SendableChooser<Character> autoGroup;
    private SendableChooser<Command> chooser = new SendableChooser<>();


    @Override
    //Initalizing
    public void robotInit() {

        drive = new Drive();
        CameraServer.getInstance().startAutomaticCapture();
        gameData = DriverStation.getInstance().getGameSpecificMessage();

        NetworkTable.getTable("SmartDashboard").putDouble("Pi", 3);
        pi = NetworkTable.getTable("SmartDashboard").getDouble("Pi", 0);


        // ALWAYS INIT OI LAST
        oi = new OI();


        chooser.setDefaultOption("Auto Master", new AutonomousMaster(autoGroup.getSelected(), gameData, autoSide.getSelected()));


        autoGroup = new SendableChooser<>();
        autoGroup.addDefault("Group 1", '1');
        autoGroup.addObject("Group 2", '2');
        autoGroup.addObject("Group 3", '3');
        autoGroup.addObject("Group 4", '4');
        SmartDashboard.putData("Autonomous", autoGroup);

        autoSide = new SendableChooser<>();
        autoSide.addObject("Left Side", 'L');
        autoSide.addDefault("Right Side", 'R');
        SmartDashboard.putData("Side", autoSide);


        SmartDashboard.putData(drive);

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

        autonomousCommand = new AutonomousMaster(autoGroup.getSelected(), gameData, autoSide.getSelected());
        autonomousCommand.start();


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

        Scheduler.getInstance().run();

    }

    @Override
    public void teleopInit() {

        autonomousCommand.cancel();


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

