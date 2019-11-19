package frc.team3100.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.RobotMap;

public class MotorRun1 extends Command {

    protected void initialize() {

    }

    //Testing command to run motors
    protected void execute() {

        if (RobotMap.driveControls.getButtonY()) {

            RobotMap.auxMotor.set(0.25);
            RobotMap.auxMotor2.set(0.25);

        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}


