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
		joystick_right = new Joystick(RobotMap.JOYSTICK_0);
		joystick_left = new Joystick(RobotMap.JOYSTICK_1);
	}
	
	@Override
	public void teleopPeriodic() {
		double inputX_right = joystick_right.getX();
		double inputY_left = joystick_left.getY();
		
		if(Math.abs(inputX_right) <= 0.15)
			inputX_right = 0;
		if(Math.abs(inputY_left) <= 0.15)
			inputY_left = 0;

		driveTrain.setArcade(inputX_right, inputY_left);
		
		if(joystick_right.getRawButton(1))
			BallDrive.setPower(RobotMap.SHOOTER_POWER, true);
		else
			BallDrive.setPower(0.0, false);
	}
}
