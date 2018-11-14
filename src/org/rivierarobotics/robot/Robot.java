package org.rivierarobotics.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	private DriveTrain driveTrain;
	private Joystick joystick_right;
	private Joystick joystick_left;
	private boolean tankDrive = false;
	
	@Override
	public void robotInit() {
		driveTrain = new DriveTrain();
		joystick_right = new Joystick(0);
		joystick_left = new Joystick(1);
	}
	
	@Override
	public void teleopPeriodic() {
		double inputX_right = joystick_right.getX();
		double inputY_right = joystick_right.getY();
		double inputY_left = joystick_left.getY();
		if(joystick_right.getRawButton(2)) {
			tankDrive = true;
		} else if (joystick_right.getRawButton(3)) {
			tankDrive = false;
		}
		
		if (tankDrive) {
			driveTrain.setPower(inputY_left, inputY_right);
		} else {
			if(Math.abs(inputX_right) <= 0.15) {
				inputX_right = 0;
			}
			if(Math.abs(inputY_right) <= 0.15) {
				inputY_right = 0;
			}
			
			driveTrain.setArcade(inputX_right, inputY_right);
		}/*
		//practicebot deadband & drive
		if(Math.abs(inputX_right) <= 0.15) {
			inputX_right = 0;
		}
		if(Math.abs(inputY_left) <= 0.15) {
			inputY_left = 0;
		}
		driveTrain.setArcade(inputX_right, inputY_left);*/
		
		//practicebot button test code
		/*while(joystick_right.getRawButton(1)) {
			driveTrain.setPower(0.2, 0.2);
		}
		driveTrain.setPower(0.0, 0.0);*/
	}
}
