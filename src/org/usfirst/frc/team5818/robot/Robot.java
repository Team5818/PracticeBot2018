package org.usfirst.frc.team5818.robot;

import org.usfirst.frc.team5818.robot.ball.BallDrive;
import org.usfirst.frc.team5818.robot.drive.DriveTrain;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	private DriveTrain driveTrain;
	private BallDrive ballDrive;
	private Joystick joystick_right;
	private Joystick joystick_left;
	
	@Override
	public void robotInit() {
		driveTrain = new DriveTrain();
		joystick_right = new Joystick(RobotMap.JOYSTICK_0);
		joystick_left = new Joystick(RobotMap.JOYSTICK_1);
		ballDrive = new BallDrive();
	}
	
	@Override
	public void teleopPeriodic() {
		double inputX_right = joystick_right.getX();
		double inputY_left = joystick_left.getY();
		double throttle_right = joystick_right.getThrottle();
		boolean shoot_joy_read = joystick_right.getRawButton(RobotMap.SHOOTER_BUTTON);
		boolean shoot_act = false;
		
		//toggle for shooter wheel
		if(shoot_joy_read && !shoot_act) {
			shoot_act = true;
		} else if(shoot_joy_read && shoot_act) {
			shoot_act = false;
		}
		
		//temp deadband, replace with vector deadband
		if(Math.abs(inputX_right) <= RobotMap.DRIVE_DEADBAND) {
			inputX_right = 0;
		} else {
			inputX_right *= RobotMap.DRIVE_PWR_MULT;
		}
		if(Math.abs(inputY_left) <= RobotMap.DRIVE_DEADBAND) {
			inputY_left = 0;
		} else {
			inputY_left *= RobotMap.DRIVE_PWR_MULT;
		}

		driveTrain.setArcade(inputX_right, inputY_left);
		
		//throttle deadband (for ball propulsion)
		if(shoot_act) {
			if(throttle_right >= RobotMap.FEEDER_DEADBAND){
				ballDrive.setPower(throttle_right, RobotMap.SHOOTER_POWER);
			} else {
				ballDrive.setPower(0.0, RobotMap.SHOOTER_POWER);
			}
		} else {
			if(throttle_right >= RobotMap.FEEDER_DEADBAND) {
				ballDrive.setPower(throttle_right, 0.0);
			} else {
				ballDrive.setPower(0.0, 0.0);
			}
		}
		
	}
}