package frc.team3100.robot.Shooter;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.RobotMap;

public class Shooter extends Subsystem {

    public Shooter(){
        super("Shooter");
    }

    public void run() {


    }




    @Override
    protected void initDefaultCommand() {

        setDefaultCommand(new ShooterRun());

    }
}
