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
/**
 *
 */
public class flipper extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController motorR = RobotMap.elbowMotor;
    SpeedController motorL = RobotMap.flippermotorL;
    DigitalInput switchL = RobotMap.flipperswitchL;
    DigitalInput switchR = RobotMap.flipperswtchR;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public synchronized void flipLeft(){
        motorL.set(-Constants.flipperSpeed);
        try {
            wait(Constants.flipperWait);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if (switchL.get() == false){
            motorL.set(Constants.flipperReturnSpeed);
        }
        else{
            motorL.set(0.0);
        }
    }
    
    public synchronized void flipRight(){
        motorR.set(Constants.flipperSpeed);
        try {
            wait(Constants.flipperWait);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if(switchR.get() == false){
            motorR.set(-Constants.flipperReturnSpeed);
        }
        else{
            motorR.set(0.0);
        } 
    }
    
    public synchronized void flipBoth(){
        motorL.set(-Constants.flipperSpeed);
        motorR.set(Constants.flipperSpeed);
        try {
            wait(Constants.flipperWait);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if(switchL.get() == false){
            motorL.set(Constants.flipperReturnSpeed);
            motorR.set(-Constants.flipperReturnSpeed);
        }
        else{
            motorL.set(0.0);
            motorR.set(0.0);
        }
    }
    public void flipClose(){
        if(switchL.get() == false){
            motorL.set(Constants.flipperReturnSpeed);
            motorR.set(-Constants.flipperReturnSpeed);
        }
        else{
            motorL.set(0.0);
            motorR.set(0.0);
        }
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new FlipClose());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
