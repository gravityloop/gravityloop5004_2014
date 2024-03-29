// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc5004.gravLoop_2014.subsystems;
import org.usfirst.frc5004.gravLoop_2014.RobotMap;
import org.usfirst.frc5004.gravLoop_2014.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5004.gravLoop_2014.Constants;
import org.usfirst.frc5004.gravLoop_2014.Robot;
/**
 *
 */
public class Drivetrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController driveLeft = RobotMap.drivetraindriveLeft;
    SpeedController driveRight = RobotMap.drivetraindriveRight;
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    double throttle;
    public static boolean useThrottle = false;
    
    public void drive(){
        if(useThrottle){
            throttle = ((Robot.oi.jDriveL.getRawAxis(3)+1)/2);
        }else{
            throttle = 1;
        }
        driveLeft.set(-(Robot.oi.jDriveL.getY()*throttle));
        driveRight.set(Robot.oi.jDriveR.getY()*throttle);
       
    }
    
    public synchronized void autonomous(){
        driveLeft.set(-Constants.autoSpeed);
        driveRight.set(Constants.autoSpeed);
        
        try {
            wait(Constants.autoWait);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        driveLeft.set(0.0);
        driveRight.set(0.0);
        
        //Robot.ramp.upWait();
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new Drive());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
