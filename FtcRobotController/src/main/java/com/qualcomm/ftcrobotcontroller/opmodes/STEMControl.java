package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Declan Freeman-Gleason on 4/27/2016.
 */
public class STEMControl extends OpMode {
	DcMotor motorRight;
	DcMotor motorLeft;
	Servo mainServo;
	@Override
	public void init () {
		//** Tell the User that the program is initializing **//
		telemetry.addData("log", "Program initialization start...");

		//** Add the Right Motor **//
		motorRight = hardwareMap.dcMotor.get("motorRight");

		//** Add the Left Motor **//
		motorLeft = hardwareMap.dcMotor.get("motorLeft");

		//** Add the Main Servo **//
		mainServo = hardwareMap.servo.get("mainServo");

		//** Set the Motor Directions **//
		motorRight.setDirection(DcMotor.Direction.FORWARD); // Set the Right Motor to Forward Direction
		motorLeft.setDirection(DcMotor.Direction.REVERSE); // Set the Left Motor to Reverse Direction

		//** Tell the User that the program is finished initializing **//
		telemetry.addData("log", "Program finished initialization...");
	}

	@Override
	public void loop () {
		//** Set the Power of the Right Motor **//
		motorRight.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));
		//** Set the Power of the Left Motor **//
		motorLeft.setPower(Range.clip(gamepad1.left_stick_y, -1, 1));
		if(gamepad1.right_bumper) {
			mainServo.setPosition(Range.clip(mainServo.getPosition() + 0.01, 0, 1));
		} else if(gamepad1.left_bumper) {
			mainServo.setPosition(Range.clip(mainServo.getPosition() - 0.01, 0, 1));
		}
	}
}
