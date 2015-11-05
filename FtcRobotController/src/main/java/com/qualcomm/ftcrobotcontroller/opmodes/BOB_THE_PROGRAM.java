package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LegacyModule;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;
import com.qualcomm.robotcore.util.Range;

import java.math.BigDecimal;

/**
 * Created by Christopher Mentzer and Declan Freeman-Gleason on 10/11/2015.
 */
public class BOB_THE_PROGRAM extends OpMode{
    double servoPosition = 0;
    boolean increment = true;
    Servo servo1;
    DcMotor MotorRight;
    DcMotor MotorLeft;
    TouchSensor touchSensor;
    UltrasonicSensor ultrasonicSensor;
    @Override
    public void init() {
        Range.clip(servoPosition, 0, 1);
        MotorRight = hardwareMap.dcMotor.get("RightMotor");
        MotorLeft = hardwareMap.dcMotor.get("LeftMotor");
        MotorLeft.setDirection(DcMotor.Direction.REVERSE);
        servo1 = hardwareMap.servo.get("servo1");
        touchSensor = hardwareMap.touchSensor.get("TouchSensor");
        hardwareMap.ultrasonicSensor.get("UltrasonicSensor");

        servo1.setPosition(0);
    }

    @Override
    public void loop() {
        //  while (true) {
        double RightMotor = 0;
        double LeftMotor = 0;
        double turnScale = 0;
        if (!touchSensor.isPressed()) {
//            if(servo1.getPosition() >= 0.98) {
//                increment = false;
//            }else if(servo1.getPosition() <= 0.02) {
//                increment = true;
//            }
//            if (!increment) {
//                servoPosition -= 0.01;
//
//            }else if (increment){
//                servoPosition += 0.01;
//            }
//            Range.clip(servoPosition,0,1)
            servoPosition = gamepad1.left_trigger;
    }
        servo1.setPosition(servoPosition);
        double LeftStickValueY = gamepad1.left_stick_y;
        double LeftStickValueX = gamepad1.right_stick_x;
        if (LeftStickValueX > 0 && LeftStickValueX <= 0.5) {
            turnScale = 0.5;
        } else if (LeftStickValueX > 0.5 && LeftStickValueX <= 0.1) {
            turnScale = 1;
        }else if (LeftStickValueX > -0.5 && LeftStickValueX <= 0) {
            turnScale = -0.5;
        }else if (LeftStickValueX > -1 && LeftStickValueX <= 0.5) {
            turnScale = -1;
        }else  if (LeftStickValueX == 0) {
            turnScale = 1;
        }
        if (LeftStickValueY != 0) {
            if (LeftStickValueX == 0) {
                LeftMotor = LeftStickValueY;
                RightMotor = LeftStickValueY;
            }else {
                LeftMotor = LeftStickValueY * turnScale;
                RightMotor = LeftStickValueY * -turnScale;
            }
        }
        MotorLeft.setPower(LeftMotor);
        MotorRight.setPower(RightMotor);
        double UltraSensor = ultrasonicSensor.getUltrasonicLevel();
        telemetry.addData("Ultrasonic Sensor","The Ultrasonic Sensor value is: " + UltraSensor);
    }
}
