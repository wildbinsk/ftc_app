package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by wilkes234 on 11/18/2015.
 */
public class Autonomous_MoveToBox extends OpMode {
    Servo servo1;
    Servo servo2;
    Servo servo3;
    Servo servo4;
    final static int inchRotation = 42;
    DcMotor MotorRight_F;
    DcMotor MotorLeft_F;
    DcMotor MotorRight_B;
    DcMotor MotorLeft_B;
    @Override
    public void init() {
        MotorRight_F = hardwareMap.dcMotor.get("RightMotorF");
        MotorLeft_F = hardwareMap.dcMotor.get("LeftMotorF");
        MotorRight_B = hardwareMap.dcMotor.get("RightMotorB");
        MotorLeft_B = hardwareMap.dcMotor.get("LeftMotorB");
        MotorRight_F.setDirection(DcMotor.Direction.REVERSE);
        MotorRight_B.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft_F.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorRight_F.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorLeft_B.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorRight_B.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");
        servo1.setPosition(-1);
        servo2.setPosition(-1);
        servo3.setPosition(-1);
        servo4.setPosition(-1);
    }

    @Override
    public void loop() {
        MotorLeft_F.setTargetPosition(inchRotation * 112);
        MotorRight_F.setTargetPosition(inchRotation * 112);
        MotorLeft_B.setTargetPosition(inchRotation * 112);
        MotorRight_B.setTargetPosition(inchRotation * 112);
        MotorLeft_F.setPower(0.25);
        MotorRight_F.setPower(0.25);
        MotorLeft_B.setPower(0.25);
        MotorRight_B.setPower(0.25);
        if (MotorLeft_F.getCurrentPosition() + MotorRight_F.getCurrentPosition() + MotorRight_F.getCurrentPosition() + MotorRight_B.getCurrentPosition() >= inchRotation * 448) {
            MotorLeft_F.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
            MotorRight_F.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
            MotorLeft_B.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
            MotorRight_B.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
            MotorLeft_F.setPower(0);
            MotorRight_F.setPower(0);
            MotorLeft_B.setPower(0);
            MotorRight_B.setPower(0);
        }
    }
}
