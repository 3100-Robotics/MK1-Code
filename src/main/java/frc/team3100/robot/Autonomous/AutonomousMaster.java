package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
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

TO WAIT:
addSequential(new WaitCommand(SECONDS));
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

                //Drive Forward
                addSequential(new AutoDriveForward(1.5));

            } else if (autoSide == 'L') {

                //Drive Forward
                addSequential(new AutoDriveForward(1.5));

            }

        }

        //GROUP 2 - TT
        else if (autoGroup == '2') {
                if (autoSide == 'R') {

                    //Go straight, turn right, go forward, turn left, stop - To Advanced Industrial
                    addSequential(new AutoDriveForward(1.55));
                    addSequential(new AutoDriveRight(0.52));
                    addSequential(new AutoDriveForward(2.9));
                    addSequential(new AutoDriveLeft(0.21));
                    addSequential(new AutoDriveForward(1));



                } else if (autoSide == 'L') {

                    //Go straight, turn left, go forward, turn right, stop - To Advanced Industrial

                    addSequential(new AutoDriveForward(1.55));
                    addSequential(new AutoDriveLeft(0.52));
                    addSequential(new AutoDriveForward(2.9));
                    addSequential(new AutoDriveRight(0.21));
                    addSequential(new AutoDriveForward(1));


                }
            }

            //GROUP 3 - T&EE
         else if (autoGroup == '3') {
            if (autoSide == 'R') {

                //Goto Industrial Zone

                addSequential(new AutoDriveForward(1.45));
                addSequential(new AutoDriveRight(0.58));
                addSequential(new AutoDriveForward(3));

            } else if (autoSide == 'L') {

                //Goto Industrial Zone

                addSequential(new AutoDriveForward(1.45));
                addSequential(new AutoDriveLeft(0.58));
                addSequential(new AutoDriveForward(3));

            }

            //GROUP 4 - E3100
        } else if (autoGroup == '4') {
            if (autoSide == 'R') {

                //Goto Industrial Zone

                addSequential(new AutoDriveForward(1.45));
                addSequential(new AutoDriveRight(0.58));
                addSequential(new AutoDriveForward(3));

            } else if (autoSide == 'L') {

                //Goto Industrial Zone

                addSequential(new AutoDriveForward(1.45));
                addSequential(new AutoDriveLeft(0.58));
                addSequential(new AutoDriveForward(3));

            }

        }else if (autoGroup == '5'){

             //Testing
            addSequential(new AutoDriveRight(0.65));
            addSequential(new AutoDriveForward(1.45));
            addSequential(new AutoDriveLeft(0.58));

        }


    }


}
