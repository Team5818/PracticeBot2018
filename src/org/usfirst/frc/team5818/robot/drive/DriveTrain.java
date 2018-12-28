package org.usfirst.frc.team5818.robot.drive;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{
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
	
	public void resetDistance() {
		this.left.setDistance(0);
		this.right.setDistance(0);
	}
	
	public double getAverageDistance() {
		double leftDistance = this.left.getDistance();
		double rightDistance = this.right.getDistance();
		return (leftDistance + rightDistance)/2;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}