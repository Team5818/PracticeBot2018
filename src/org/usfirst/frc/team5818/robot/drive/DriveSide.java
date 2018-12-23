package org.usfirst.frc.team5818.robot.drive;

import org.usfirst.frc.team5818.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSide {
	private WPI_TalonSRX motorZed;
	private WPI_TalonSRX motorEnc;
	
	public DriveSide(boolean isLeft) {
		if(isLeft) {
			motorZed = new WPI_TalonSRX(RobotMap.TALON_LEFT_ZED);
			motorEnc = new WPI_TalonSRX(RobotMap.TALON_LEFT_ENC);
		} else {
			motorZed = new WPI_TalonSRX(RobotMap.TALON_RIGHT_ZED);
			motorEnc = new WPI_TalonSRX(RobotMap.TALON_RIGHT_ENC);
			motorZed.setInverted(true);
			motorEnc.setInverted(true);
		}
	}
	
	public void setPower(double pwr) {
		motorZed.set(pwr);
		motorEnc.set(pwr);
	}
	
	public void setDistance(double inches) {
		motorEnc.getSensorCollection().setQuadraturePosition(
				(int) (inches / RobotMap.COUNTS_TO_INCHES_FACTOR), 10);
	}
	
	public double getDistance() {
		return motorEnc.getSensorCollection().getQuadraturePosition() *RobotMap.COUNTS_TO_INCHES_FACTOR;  
	}
}