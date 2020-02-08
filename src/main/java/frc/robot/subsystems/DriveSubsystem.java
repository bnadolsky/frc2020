/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  //Instant Motor Controller Objects
  //Left Side of DriveTrain
  public WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.leftTalonMcFront);
  public WPI_VictorSPX leftFollower = new WPI_VictorSPX(Constants.leftVictorMcFollower);
  //Right Side of DriveTrain
  public WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.rightTalonMcFront);
  public WPI_VictorSPX rightFollower = new WPI_VictorSPX(Constants.rightVictorMcFollower);

  //Instant Differential Drive Object
  public DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);  


  public DriveSubsystem() {
    //Point Followers to Front
    leftFollower.follow(leftFront);
    rightFollower.follow(rightFront);
  }

  //add TeleOp controlled Method
  public void manualDrive(double xSpeed, double zRotation, boolean squaredInputs) {
    drive.arcadeDrive(xSpeed, zRotation, squaredInputs);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
