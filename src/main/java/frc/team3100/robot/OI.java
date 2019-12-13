package frc.team3100.robot;


import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Commands.WallExtend;
import frc.team3100.robot.Commands.dooblePiston;
import frc.team3100.robot.Commands.MotorRun;
import frc.team3100.robot.Commands.MoveBackwards;

public class OI {


    //Sets up buttons
    Button piston = new JoystickButton(RobotMap.techControls, RobotMap.rightBumperChannel);
    Button doublePiston = new JoystickButton(RobotMap.techControls, RobotMap.aButtonChannel);
    Button motorRun = new JoystickButton(RobotMap.techControls, RobotMap.bButtonChannel);
    Button motorRun1 = new JoystickButton(RobotMap.techControls, RobotMap.yButtonChannel);
    Button motorRun2 = new JoystickButton(RobotMap.techControls, RobotMap.xButtonChannel);
    Button motorRun3 = new JoystickButton(RobotMap.techControls, RobotMap.leftBumperChannel);
   // Button moveBackwards = new JoystickButton(RobotMap.driveControls, RobotMap.aButtonChannel);



    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // button.whenPressed(new ExampleCommand());

    // button.whileHeld(new ExampleCommand());

    // button.whenReleased(new ExampleCommand());

    public OI() {

        //Sets up the buttons to activate when pressed
        piston.toggleWhenPressed(new WallExtend());
        doublePiston.toggleWhenPressed(new dooblePiston());
        motorRun.whenPressed(new MotorRun());
        motorRun1.whenPressed(new MotorRun());
        motorRun2.whenPressed(new MotorRun());
        motorRun3.whenPressed(new MotorRun());



    }


}