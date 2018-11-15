package org.rivierarobotics.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallDrive {
	private static WPI_TalonSRX feeder;
	private static WPI_TalonSRX shooter;
	
	public BallDrive() {
		feeder = new WPI_TalonSRX(RobotMap.FEEDER_WHEEL);
		shooter = new WPI_TalonSRX(RobotMap.SHOOTER_WHEEL);
	}
	
	public void setPower(double f_pwr, double s_pwr) {
		feeder.set(f_pwr);
		shooter.set(s_pwr);
	}
	
	//convert to drivetrain class, make "driveside" class and copy style of drivetrain
}
