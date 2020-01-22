package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive extends Subsystem {
    private DcMotor[] motors;
    public static final String[] motorNames = {"MotorFL", "MotorFR", "MotorBL", "MotorBR"};

    public MecanumDrive(HardwareMap map) {
        for (int i = 0; i < 4; i++) {
            motors[i] = map.dcMotor.get(motorNames[i]);
            if(motors[i] != null){
                motors[i].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                motors[i].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                motors[i].setPower(0);
            }
        }

        motors[0].setDirection(DcMotorSimple.Direction.REVERSE);
        motors[2].setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void ResetMotors(){
        for(DcMotor motor : motors){
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

    public void StopMotors(){
        motors[0].setPower(0);
        motors[1].setPower(0);
        motors[2].setPower(0);
        motors[3].setPower(0);
    }
}
