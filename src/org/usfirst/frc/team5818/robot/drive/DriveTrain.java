package org.usfirst.frc.team5818.robot.drive;

public class DriveTrain {
	private DriveSide left;
	private DriveSide right;
	
	public DriveTrain() {
		left = new DriveSide(true);
		right = new DriveSide(false);
	}
	
	public void setPower(double leftIn, double rightIn) {
		left.setPower(leftIn);
		right.setPower(rightIn);
	}
	
	public void setArcade(double x, double y) {
		double left;
		double right;
		if (y >= 0) {
			left = y+x;
			right = y-x;
		} else {
			left = y-x;
			right = y+x;
		}
		setPower(left, right);
	}
}