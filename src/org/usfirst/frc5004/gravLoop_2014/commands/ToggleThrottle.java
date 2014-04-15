/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc5004.gravLoop_2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5004.gravLoop_2014.Robot;
import org.usfirst.frc5004.gravLoop_2014.subsystems.Drivetrain;

public class ToggleThrottle extends Command {
    public ToggleThrottle(){
        
    }
    
    protected void initialize(){
        Drivetrain.useThrottle =! Drivetrain.useThrottle;
    }
    
    protected void execute(){
        
    }
    
    protected boolean isFinished(){
        return false;
    }
    
    protected void end(){
        
    }
    
    protected void interrupted(){
        
    }
       
    
}
