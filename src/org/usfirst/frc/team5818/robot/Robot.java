package org.usfirst.frc.team5818.robot;

import org.usfirst.frc.team5818.robot.ball.BallDrive;
import org.usfirst.frc.team5818.robot.ball.Feeder;
import org.usfirst.frc.team5818.robot.ball.Shooter;
import org.usfirst.frc.team5818.robot.drive.DriveTrain;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	private DriveTrain driveTrain;
	private BallDrive ballDriveF;
	private BallDrive ballDriveS;
	private Joystick joystick_right;
	private Joystick joystick_left;
	
	@Override
	public void robotInit() {
		driveTrain = new DriveTrain();
		joystick_right = new Joystick(RobotMap.JOYSTICK_0);
		joystick_left = new Joystick(RobotMap.JOYSTICK_1);
		ballDriveF = new BallDrive();
		ballDriveS = new BallDrive();
	}
	
	@Override
	public void teleopPeriodic() {
		double inputX_right = joystick_right.getX();
		double inputY_left = joystick_left.getY();
		double throttle_right = joystick_right.getThrottle();
		boolean shoot_joy_read = joystick_right.getRawButton(RobotMap.FEEDER_BUTTON);
		boolean shoot_act = false;
		double fl_pwr = 0, fr_pwr = 0, sl_pwr = 0, sr_pwr = 0;
		
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
			sl_pwr = throttle_right;
			sr_pwr = throttle_right;
		} else {
			sl_pwr = 0;
			sr_pwr = 0;
		}
		if(shoot_joy_read) {
			fl_pwr = RobotMap.FEEDER_POWER;
			fr_pwr = RobotMap.FEEDER_POWER;
		} else {
			fl_pwr = 0;
			fr_pwr = 0;
		}
		ballDriveF.setPower(fl_pwr, fr_pwr);
		ballDriveS.setPower(sl_pwr, sr_pwr);
		
	}
}