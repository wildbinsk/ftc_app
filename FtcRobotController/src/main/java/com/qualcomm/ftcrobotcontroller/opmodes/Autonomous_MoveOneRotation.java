package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by wilkes234 on 11/15/2015.
 */
public class Autonomous_MoveOneRotation extends OpMode {
    DcMotor MotorRight_F;
    DcMotor MotorLeft_F;
    DcMotor MotorRight_B;
    DcMotor MotorLeft_B;
    final int PPM = 1120;
    @Override
    public void init() {
        MotorRight_F = hardwareMap.dcMotor.get("RightMotorF");
        MotorLeft_F = hardwareMap.dcMotor.get("LeftMotorF");
        MotorRight_B = hardwareMap.dcMotor.get("RightMotorB");
        MotorLeft_B = hardwareMap.dcMotor.get("LeftMotorB");
    }

    @Override
    public void loop() {
        // Set Motor Power
        MotorRight_F.setPower(0.25);
        MotorLeft_F.setPower(0.25);
        MotorRight_B.setPower(0.25);
        MotorLeft_B.setPower(0.25);
        // Set Motor Target Positions
        MotorRight_F.setTargetPosition(PPM * 10);
        MotorLeft_F.setTargetPosition(PPM * 10);
        MotorRight_B.setTargetPosition(PPM * 10);
        MotorLeft_B.setTargetPosition(PPM * 10);
    }
}
