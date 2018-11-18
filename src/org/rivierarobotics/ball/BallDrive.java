package org.rivierarobotics.ball;

public class BallDrive {
	private BallSide feeder;
	private BallSide shooter;
	
	public BallDrive() {
		feeder = new BallSide(true);
		shooter = new BallSide(false);
	}
	
	public void setPower(double f_pwr, double s_pwr) {
		feeder.setPower(f_pwr);
		shooter.setPower(s_pwr);
	}
}