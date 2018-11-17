package org.rivierarobotics.ball;

import org.rivierarobotics.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallSide {
	private WPI_TalonSRX motor1;
	private WPI_TalonSRX motor2;
	
	public BallSide(boolean isLeft) {
		if(isLeft) {
			motor1 = new WPI_TalonSRX(RobotMap.FEEDER_WHEEL_L);
			motor2 = new WPI_TalonSRX(RobotMap.SHOOTER_WHEEL_L);
		} else {
			motor1 = new WPI_TalonSRX(RobotMap.FEEDER_WHEEL_R);
			motor2 = new WPI_TalonSRX(RobotMap.SHOOTER_WHEEL_R);
			motor1.setInverted(true);
			motor2.setInverted(true);
		}
	}
	
	public void setPower(double pwr) {
		motor1.set(pwr);
		motor2.set(pwr);
	}
}