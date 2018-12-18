package org.usfirst.frc.team5818.robot.ball;

import org.usfirst.frc.team5818.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Feeder {
	private WPI_TalonSRX motorL;
	private WPI_TalonSRX motorR;
	
	public Feeder() {
		motorL = new WPI_TalonSRX(RobotMap.FEEDER_WHEEL_L);
		motorR = new WPI_TalonSRX(RobotMap.FEEDER_WHEEL_R);
		motorL.setInverted(true);
	}
	
	public void setPower(double f_pwr, double b_pwr) {
		motorL.set(f_pwr);
		motorR.set(b_pwr);
	}
}