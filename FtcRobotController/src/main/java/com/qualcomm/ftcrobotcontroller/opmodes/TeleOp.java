package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by wilkes234 on 11/4/2015.
 */
public class TeleOp extends OpMode {
    double servoPosition = 0;
    boolean increment = true;
    Servo servo1;
    DcMotor MotorRight;
    DcMotor MotorLeft;
    @Override
    public void init() {
        Range.clip(servoPosition, 0, 1);
        MotorRight = hardwareMap.dcMotor.get("RightMotor");
        MotorLeft = hardwareMap.dcMotor.get("LeftMotor");
        MotorRight.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        servo1 = hardwareMap.servo.get("servo1");

        servo1.setPosition(0);
    }

    @Override
    public void loop() {
        float rightMotor = 0;
        float leftMotor = 0;
        float leftTrigger = 0;
        Range.clip(rightMotor, 0, 1);
        Range.clip(leftMotor, 0, 1);
        Range.clip(leftTrigger, 0, 1);
        leftMotor = gamepad1.left_stick_y;
        rightMotor = gamepad1.right_stick_y;
        MotorRight.setPower(rightMotor);
        MotorLeft.setPower(leftMotor);
        leftTrigger = gamepad1.left_trigger;
        servo1.setPosition(leftTrigger);
    }
}
