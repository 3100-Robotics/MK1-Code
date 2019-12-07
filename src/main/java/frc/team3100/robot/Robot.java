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

    public class Group{

        //Autonomous Init, Periodic, Tele Int, and Periodic

    }
    public class group1{

        //Functions
        //Constructor
        //Autonomous Init, Periodic, Tele Int, and Periodic

    }

   // private class group(Groups[4]){

   // }


  //  public Robot[] GroupRobots [4]{

  //  }

    //If mode = 1, Arcade
    //If mode = 2, Tank
    public static int mode = 1;

    //If group = 1, BONK
    //If group = 2, Thunder Tortoises
    //If group = 3, Tate & Everyone Else
    //If group = 4, Error 3100
    public static int groups;

    public static OI oi;
    public static Drive drive;

    public double pi;
    private boolean ran = false;

    public static String gameData;


    private Command autonomousCommand;
    private SendableChooser <Character> autoSide;
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

        autonomousCommand = new AutonomousMaster(autoSide.getSelected());

        chooser.setDefaultOption("Auto Master", new AutonomousMaster(autoSide.getSelected()));
        chooser.addOption("Group 1", new DriveMotion());
        chooser.addOption("Group 2", new DriveMotion());
        chooser.addOption("Group 3", new DriveMotion());
        chooser.addOption("Group 4", new DriveMotion());

        autoSide = new SendableChooser<>();
        autoSide.addObject("In Front of Switch", 'O');
        autoSide.addDefault("To the Side of the Switch",'N');
        SmartDashboard.putData("Type", autoSide);

        SmartDashboard.putData("Auto mode", chooser);
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

        autonomousCommand = new AutonomousMaster(autoSide.getSelected());
       autonomousCommand.start();

        //Groups[currentGroup].autonomousInit


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

