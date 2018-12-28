package org.usfirst.frc.team5818.robot;

public class RobotMap {
	public static final int FEEDER_WHEEL_L = 4;
	public static final int FEEDER_WHEEL_R = 5;
	public static final int SHOOTER_WHEEL_L = 7;
	public static final int SHOOTER_WHEEL_R = 8;

	public static final int FEEDER_BUTTON = 1;
	public static final double FEEDER_POWER = 0.6;
	public static final double DRIVE_PWR_MULT = 0.6;

	public static final int JOYSTICK_0 = 0;
	public static final int JOYSTICK_1 = 1;

	public static final int TALON_LEFT_ZED = 1;
	public static final int TALON_LEFT_ENC = 2;
	public static final int TALON_RIGHT_ZED = 4;
	public static final int TALON_RIGHT_ENC = 3;

	public static final double DRIVE_DEADBAND = 0.15;
	public static final double SHOOTER_DEADBAND = 0.05;

	public static final double COUNTS_TO_INCHES_FACTOR = 69.47916 / 1535.6666;
}