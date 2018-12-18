package org.usfirst.frc.team5818.robot.ball;

public class BallDrive {
	private Feeder feeder;
	private Shooter shooter;
	
	public BallDrive() {
		feeder = new Feeder();
		shooter = new Shooter();
	}
	
	public void setPower(double f_pwr, double b_pwr) {
		feeder.setPower(f_pwr, b_pwr);
		shooter.setPower(f_pwr, b_pwr);
	}
}