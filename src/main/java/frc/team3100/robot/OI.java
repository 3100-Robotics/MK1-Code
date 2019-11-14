package frc.team3100.robot;


import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoDrive;
import frc.team3100.robot.Wall.WallExtend;

public class OI
{

Button piston = new JoystickButton(RobotMap.driveControls, RobotMap.rightBumperChannel);
Button driveAuto = new JoystickButton(RobotMap.driveControls, RobotMap.leftBumperChannel);




    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // button.whenPressed(new ExampleCommand());

    // button.whileHeld(new ExampleCommand());

    // button.whenReleased(new ExampleCommand());

    public OI(){

    piston.whenPressed(new WallExtend());
    driveAuto.whenPressed(new AutoDrive());

    }


}