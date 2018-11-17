package org.rivierarobotics.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSide {
	private WPI_TalonSRX motor1;
	private WPI_TalonSRX motor2;
	
	public DriveSide(boolean isLeft) {
		if(isLeft) {
			motor1 = new WPI_TalonSRX(RobotMap.TALON_LEFT_1);
			motor2 = new WPI_TalonSRX(RobotMap.TALON_LEFT_2);
		} else {
			motor1 = new WPI_TalonSRX(RobotMap.TALON_RIGHT_1);
			motor2 = new WPI_TalonSRX(RobotMap.TALON_RIGHT_2);
			motor1.setInverted(true);
			motor2.setInverted(true);
		}
	}
	
	public void setPower(double pwr) {
		motor1.set(pwr);
		motor2.set(pwr);
	}
}