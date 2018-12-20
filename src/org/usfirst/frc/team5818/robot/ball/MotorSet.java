package org.usfirst.frc.team5818.robot.ball;

import org.usfirst.frc.team5818.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class MotorSet {
	private WPI_TalonSRX motorL;
	private WPI_TalonSRX motorR;
	
	public MotorSet(boolean isFeeder) {
		if(isFeeder) {
			motorL = new WPI_TalonSRX(RobotMap.FEEDER_WHEEL_L);
			motorR = new WPI_TalonSRX(RobotMap.FEEDER_WHEEL_R);
		} else {
			motorL = new WPI_TalonSRX(RobotMap.SHOOTER_WHEEL_L);
			motorR = new WPI_TalonSRX(RobotMap.SHOOTER_WHEEL_R);
		}
		motorL.setInverted(true);
	}
	
	public void setPower(double l_pwr, double r_pwr) {
		motorL.set(l_pwr);
		motorR.set(r_pwr);
	}
}