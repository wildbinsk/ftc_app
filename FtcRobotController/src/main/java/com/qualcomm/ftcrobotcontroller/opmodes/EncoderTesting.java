package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.robocol.Telemetry;

/**
 * Created by Declan Freeman-Gleason on 11/1/2015.
 */
public class EncoderTesting extends OpMode {
    DcMotor LeftMotor;
    DcMotor RightMotor;
    final int PPM = 1120;
    @Override
    public void init() {
        LeftMotor = hardwareMap.dcMotor.get("LeftMotor");
        LeftMotor.setDirection(DcMotor.Direction.REVERSE);
        RightMotor = hardwareMap.dcMotor.get("RightMotor");
        telemetry.addData("Encoder Positions","LeftMotor: " + LeftMotor.getCurrentPosition() + " RightMotor: " + RightMotor.getCurrentPosition());
        LeftMotor.setTargetPosition(0);
        RightMotor.setTargetPosition(0);
        telemetry.addData("Encoder Positions", "LeftMotor: " + LeftMotor.getCurrentPosition() + " RightMotor: " + RightMotor.getCurrentPosition());
        LeftMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        telemetry.addData("Encoder Positions", "LeftMotor: " + LeftMotor.getCurrentPosition() + " RightMotor: " + RightMotor.getCurrentPosition());
    }
    @Override
    public void loop() {
        // Encoders have been reset.
        LeftMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        RightMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        LeftMotor.setTargetPosition(PPM);
        RightMotor.setTargetPosition(PPM);
        LeftMotor.setPower(.25);
        RightMotor.setPower(.25);
        telemetry.addData("Encoder Positions","LeftMotor: " + LeftMotor.getCurrentPosition() + " RightMotor: " + RightMotor.getCurrentPosition());
//        if ((LeftMotor.getTargetPosition() - LeftMotor.getCurrentPosition()) < PPM) {
//            LeftMotor.setPowerFloat();
//        }
//        if ((RightMotor.getTargetPosition() - RightMotor.getCurrentPosition()) < PPM) {
//            RightMotor.setPowerFloat();
//        }

    }
}
