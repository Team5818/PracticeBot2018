package org.rivierarobotics.ball;

public class BallDrive {
	private BallSide left;
	private BallSide right;
	
	public BallDrive() {
		left = new BallSide(true);
		right = new BallSide(false);
	}
	
	public void setPower(double f_pwr, double s_pwr) {
		left.setPower(f_pwr);
		right.setPower(s_pwr);
	}
}