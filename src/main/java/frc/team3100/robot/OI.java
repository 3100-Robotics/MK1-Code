package frc.team3100.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Commands.MotorRun;
import frc.team3100.robot.Commands.MoveBackwards;
import frc.team3100.robot.Commands.WallExtend;

public class OI {


    //Sets up buttons
    Button piston = new JoystickButton(RobotMap.techControls, RobotMap.rightBumperChannel);
    Button motorRun = new JoystickButton(RobotMap.techControls, RobotMap.bButtonChannel);
    Button motorRun1 = new JoystickButton(RobotMap.techControls, RobotMap.yButtonChannel);
    Button motorRun2 = new JoystickButton(RobotMap.techControls, RobotMap.xButtonChannel);
    Button moveBackwards = new JoystickButton(RobotMap.techControls, RobotMap.aButtonChannel);


    public static boolean motorRan = false;
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // button.whenPressed(new ExampleCommand());

    // button.whileHeld(new ExampleCommand());

    // button.whenReleased(new ExampleCommand());

    public OI() {

        //Sets up the buttons to activate when pressed
        piston.toggleWhenPressed(new WallExtend());
        motorRun.whenPressed(new MotorRun());
        motorRun1.whenPressed(new MotorRun());
        motorRun2.whenPressed(new MotorRun());
        moveBackwards.whenPressed(new MoveBackwards());


    }


}