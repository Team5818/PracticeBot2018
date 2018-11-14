package org.rivierarobotics.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

public class BallDrive {
	private static WPI_TalonSRX feeder;
	private static Solenoid shooter;
	
	public BallDrive() {
		feeder = new WPI_TalonSRX(RobotMap.FEEDER_WHEEL);
		shooter = new Solenoid(RobotMap.SHOOTER_WHEEL);
	}
	
	public static void setPower(double pwr, boolean on) {
		feeder.set(pwr);
		shooter.set(on);
	}
}
