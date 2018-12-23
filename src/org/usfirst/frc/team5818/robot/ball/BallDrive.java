package org.usfirst.frc.team5818.robot.ball;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallDrive extends Subsystem {
	private MotorSet feeder;
	private MotorSet shooter;
	
	public BallDrive() {
		feeder = new MotorSet(true);
		shooter = new MotorSet(false);
	}
	
	public void setPower(double left_feed, double right_feed, double left_shoot, double right_shoot) {
		feeder.setPower(left_feed, right_feed);
		shooter.setPower(left_shoot, right_shoot);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}