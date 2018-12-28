package org.usfirst.frc.team5818.robot.commands;

import org.usfirst.frc.team5818.robot.Robot;
import org.usfirst.frc.team5818.robot.drive.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {

	private final DriveTrain dt = Robot.INSTANCE.driveTrain;
	private final double distance;
	private final double power;
	private double startPosition;
	private double currentPosition;

	public DriveForward(double distance, double power) {
		this.distance = distance;
		this.power = power;
		requires(dt);
	}

	@Override
	protected void initialize() {
		startPosition = dt.getAverageDistance();

	}

	@Override
	protected void execute() {
	dt.setPower(power, power);
	currentPosition = dt.getAverageDistance();
	}
	@Override
	protected void end() {
		dt.setPower(0, 0);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(currentPosition - startPosition) >= distance;
	}

}
