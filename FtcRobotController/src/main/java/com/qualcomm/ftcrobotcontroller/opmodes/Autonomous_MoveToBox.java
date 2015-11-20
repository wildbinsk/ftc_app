package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Declan Freeman-Gleason on 11/18/2015.
 */
public class Autonomous_MoveToBox extends OpMode {
    public double inchRotation = 0.31723728432;
    Servo servo1;
    Servo servo2;
    Servo servo3;
    Servo servo4;
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
        MotorLeft_F.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft_B.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft_F.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorRight_F.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorLeft_B.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorRight_B.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");
        servo1.setPosition(0);
        servo2.setPosition(0);
        servo3.setPosition(0);
        servo4.setPosition(0);
    }
    @Override
    public void loop() {
        MotorLeft_F.setTargetPosition(round(inchRotation * 112));
        MotorRight_F.setTargetPosition(round(inchRotation * 112));
        MotorLeft_B.setTargetPosition(round(inchRotation * 112));
        MotorRight_B.setTargetPosition(round(inchRotation * 112));
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
    private int round(double d){
        double dAbs = Math.abs(d);
        int i = (int) dAbs;
        double result = dAbs - (double) i;
        if(result<0.5){
            return d<0 ? -i : i;
        }else{
            return d<0 ? -(i+1) : i+1;
        }
    }
//    public double inchesToRotations(double pInches) {
//
//        return pInches;
//    }
}
