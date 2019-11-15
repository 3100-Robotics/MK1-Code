package frc.team3100.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.RobotMap;

public class MotorRun extends Command {

    protected void initialize(){

    }

    protected void execute() {

        if(RobotMap.driveControls.getButtonB()){

            RobotMap.auxMotor.set(-0.75);
            RobotMap.auxMotor2.set(-0.75);

        }else{

            RobotMap.auxMotor.set(0);
            RobotMap.auxMotor2.set(0);

        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
