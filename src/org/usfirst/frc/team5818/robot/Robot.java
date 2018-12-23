package org.usfirst.frc.team5818.robot;

import org.usfirst.frc.team5818.robot.ball.BallDrive;
import org.usfirst.frc.team5818.robot.drive.DriveTrain;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public void disabledInit() {
		this.driveTrain.resetDistance();
	}
	@Override
	public void disabledPeriodic() {
		
		SmartDashboard.putNumber("AverageDistance", this.driveTrain.getAverageDistance());
	}
	
	@Override
	public void teleopPeriodic() {
		double inputX_right = joystick_right.getX();
		double inputY_left = joystick_left.getY();
		double throttle_right = joystick_right.getThrottle();
		boolean shoot_joy_read = joystick_right.getRawButton(RobotMap.FEEDER_BUTTON);
		//boolean shoot_act = false;
		double left_feed_pwr = 0, right_feed_pwr = 0, left_shoot_pwr = 0, right_shoot_pwr = 0;
		
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
		
		//toggle for shooter wheel
		/*if(shoot_joy_read && !shoot_act) {
			shoot_act = true;
		} else if(shoot_joy_read && shoot_act) {
			shoot_act = false;
		}*/
		
		//throttle deadband (for ball propulsion)
		if(throttle_right >= RobotMap.SHOOTER_DEADBAND){
			left_shoot_pwr = throttle_right;
			right_shoot_pwr = throttle_right;
		} else {
			left_shoot_pwr = 0;
			right_shoot_pwr = 0;
		}
		if(shoot_joy_read) {
			left_feed_pwr = RobotMap.FEEDER_POWER;
			right_feed_pwr = RobotMap.FEEDER_POWER;
		} else {
			left_feed_pwr = 0;
			right_feed_pwr = 0;
		}
		ballDrive.setPower(left_feed_pwr, right_feed_pwr, left_shoot_pwr, right_shoot_pwr);
		
	}
}