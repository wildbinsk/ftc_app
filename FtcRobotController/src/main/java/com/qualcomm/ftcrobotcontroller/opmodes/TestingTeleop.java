package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.robocol.Telemetry;

/**
 * Created by wilkes234 on 10/28/2015.
 */
public class TestingTeleop extends LinearOpMode {
    DcMotor testingMotor;
    double randomMotorPos;

    public void runOpMode() {
        testingMotor = hardwareMap.dcMotor.get("testingMotor");
        randomMotorPos = Math.random();
        telemetry.addData("Actual Position", randomMotorPos);
        testingMotor.setPower(randomMotorPos);
        telemetry.addData("Percevied Position", testingMotor.getCurrentPosition());
        testingMotor.setPower(0);
    }
}
