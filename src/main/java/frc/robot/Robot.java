
package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Autonomous.*;
import frc.robot.Utilities.Constants.Constants;
import frc.robot.Utilities.Drivers.MinoGamepad;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

    public static CameraServer cs;
    public static MinoGamepad gamepad1;
    public static MinoGamepad gamepad2;

    public static DriveTrain driveTrain;
//    public static Vision vision;
//    public static Lift lift;
    public static Lift liftPID;
    public static Arm arm;
    public static Intake intake;


    public static boolean isTeleop = false;
    public static boolean isDisabled = false;

    SendableChooser<Auto> autoChooser = new SendableChooser<>();
    public SendableChooser<Auto> gyroDriveChooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        
        gamepad1 = new MinoGamepad(Constants.gamepad1Port);
        gamepad2 = new MinoGamepad(Constants.gamepad2Port);
        cs = CameraServer.getInstance();
        cs.startAutomaticCapture();
        //READD THIS DUMMY


        driveTrain = DriveTrain.getInstance();
//        vision = new Vision();
//        lift = Lift.getInstance();
        liftPID = Lift.getInstance();
        arm = Arm.getInstance();
        intake = Intake.getInstance();


        autoChooser.addOption("Do nothing :O", null);
        autoChooser.addOption("TURN TEST", new TurnTest());
        autoChooser.addOption("Drive To Tower", new DriveToTower());
        autoChooser.setDefaultOption("Teleop", new Teleop());

/*        Boolean gyroDrive = new Boolean(true);

        gyroDriveChooser.setDefaultOption("On", );
        gyroDriveChooser.setDefaultOption("On", gyroDrive);*/

        //SmartDashboard.putNumber("Delay MS (C H A N G E T H I S E V E R Y M A T C H)", 0);
        SmartDashboard.putData(autoChooser);

        resetRobot();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
        Robot.isTeleop = false;
        Robot.isDisabled = true;
        /*resetRobot();*/
        //SmartDashboard.putNumber("Disabled Init Ran", 1);
    }

    @Override
    public void disabledPeriodic() {
        Robot.isDisabled = true;
        //SmartDashboard.putNumber("Disabled Init Ran", 2);
        Scheduler.getInstance().run();
        /*resetRobot();*/
    }

    /**
     * This autonomous (along with the autoChooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * autoChooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the autoChooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     * <p>
     * You can add additional auto modes by adding additional Autonomous to the
     * autoChooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & Autonomous.
     */

    private Auto a;


    @Override
    public void autonomousInit() {
        Robot.isDisabled = false;
        //SmartDashboard.putNumber("Disabled Init Ran", 0);
        resetRobot();

        a = autoChooser.getSelected();

        if (a != null) {
            a.auto();
        }
    }



    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {

        Scheduler.getInstance().run();
        if (a != null) {
            a.loop();
        }

        SmartDashboard.putNumber("Lift Error: ", liftPID.pidController.readPIDOutput());

    }

    @Override
    public void teleopInit() {

        if (a != null) {
            a.threadLock = null;
            a.stop();
            a = null;
        }
        isTeleop = true;
        /*resetRobot();*/

       /* SmartDashboard.putNumber("kfLeft", driveTrain.kfLeft);
        SmartDashboard.putNumber("kpLeft", driveTrain.kpLeft);
        SmartDashboard.putNumber("kiLeft", driveTrain.kiLeft);
        SmartDashboard.putNumber("kdLeft", driveTrain.kdLeft);

        SmartDashboard.putNumber("kfRight", driveTrain.kfRight);
        SmartDashboard.putNumber("kpRight", driveTrain.kpRight);
        SmartDashboard.putNumber("kiRight", driveTrain.kiRight);
        SmartDashboard.putNumber("kdRight", driveTrain.kdRight);*/

        isToggled = false;
    }

    boolean isToggled = false;

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {

        Scheduler.getInstance().run();

       driveTrain.teleop(gamepad1);

        SmartDashboard.putNumber("Lift Error: ", liftPID.pidController.get(Robot.liftPID.getLiftMasterMotor().getSensorCollection().getQuadraturePosition()));

       /*
        SmartDashboard.putNumber("left drive speed", driveTrain.getLeftTalon().getSensorCollection().getQuadratureVelocity());
        SmartDashboard.putNumber("right drive speed", driveTrain.getRightMaster().getSensorCollection().getQuadratureVelocity());

        driveTrain.kfLeft = SmartDashboard.getNumber("kfLeft", 0);
        driveTrain.kpLeft = SmartDashboard.getNumber("kpLeft", 0);
        driveTrain.kiLeft = SmartDashboard.getNumber("kiLeft", 0);
        driveTrain.kdLeft = SmartDashboard.getNumber("kdLeft", 0);

        driveTrain.kfRight = SmartDashboard.getNumber("kfRight", 0);
        driveTrain.kpRight = SmartDashboard.getNumber("kpRight", 0);
        driveTrain.kiRight = SmartDashboard.getNumber("kiRight", 0);
        driveTrain.kdRight = SmartDashboard.getNumber("kdRight", 0);

        driveTrain.setPIDGains();*/

//        lift.teleop(gamepad1);
        liftPID.teleop(gamepad1);
//        vision.teleop(gamepad1);
        arm.teleop(gamepad1);
        intake.teleop(gamepad1);


        //SmartDashboard.putNumber("Potentiometer:", lift.potentiometer.pidGet());
//		SmartDashboard.putNumber("Distance form egeg", rangeSensor.getDistance());
       /* SmartDashboard.putNumber("Left motor", driveTrain.getLeftTalon().get());
        SmartDashboard.putNumber("Right motor", driveTrain.getRightMaster().get());

        SmartDashboard.putNumber("GyroAngle", driveTrain.getGyroAngle());
        SmartDashboard.putNumber("L RPM", driveTrain.getLeftTalon().getSelectedSensorVelocity(0) >= SmartDashboard.getNumber("L RPM", 0) ? driveTrain.getLeftTalon().getSelectedSensorVelocity(0) : SmartDashboard.getNumber("L RPM", 0));
        SmartDashboard.putNumber("R RPM", driveTrain.getRightMaster().getSelectedSensorVelocity(0) >= SmartDashboard.getNumber("R RPM", 0) ? driveTrain.getRightMaster().getSelectedSensorVelocity(0) : SmartDashboard.getNumber("R RPM", 0));
        SmartDashboard.putNumber("LCurrent", driveTrain.getLeftTalon().getOutputCurrent());
        SmartDashboard.putNumber("RCurrent", driveTrain.getRightMaster().getOutputCurrent());*/

    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
    }

    public static void resetRobot() {
        //reset();
        driveTrain.resetFull();
//        lift.reset();
        liftPID.reset();
        arm.reset();
        //vision.reset();
        intake.reset();
    }
}
