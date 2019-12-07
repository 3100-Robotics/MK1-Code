package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

public class AutonomousMaster extends CommandGroup {

    /*
COPY AND PASTE THESE

TO DRIVE FORWARDS:
addSequential(new AutoDriveForward(SECONDS));

TO DRIVE BACKWARDS:
addSequential(new AutoDriveBackwards(SECONDS));

TO TURN RIGHT:
addSequential(new AutoDriveRight(SECONDS));

TO TURN LEFT:
addSequential(new AutoDriveLeft(SECONDS));
*/

    //Master grouping for all of the autonomous commands, used to sequence the commands in order
    public AutonomousMaster(Character autoGroup, String autoData, Character autoSide) {
        SmartDashboard.putString("INPUT", autoData + autoGroup + autoSide);
        SmartDashboard.putString("AutoData", autoData);

        //If group = 1, BONK
        //If group = 2, Thunder Tortoises
        //If group = 3, Tate & Everyone Else
        //If group = 4, Error 3100

        //GROUP 1 - BONK
        if (autoGroup == '1') {
            if (autoSide == 'R') {


            } else if (autoSide == 'L') {


            }

        }

        //GROUP 2 - TT
        else if (autoGroup == '2') {
            if (autoSide == 'R') {

                addSequential(new AutoDriveForward(2));
                addSequential(new AutoDriveRight(2));
                addSequential(new AutoDriveForward(4));
                addSequential(new AutoDriveLeft(2));
                addSequential(new AutoDriveForward(1));


            } else if (autoSide == 'L') {

                addSequential(new AutoDriveForward(2));
                addSequential(new AutoDriveLeft(2));
                addSequential(new AutoDriveForward(4));
                addSequential(new AutoDriveRight(2));
                addSequential(new AutoDriveForward(1));

            }

            //GROUP 3 - T&EE
        } else if (autoGroup == '3') {
            if (autoSide == 'R') {

            } else if (autoSide == 'L') {

            }

            //GROUP 3 - E3100
        } else if (autoGroup == '4') {
            if (autoSide == 'R') {

            } else if (autoSide == 'L') {

            }

        }


    }


}
