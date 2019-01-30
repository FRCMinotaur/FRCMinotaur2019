package frc.robot;

import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface Constants {

    //Hardware Ports
    int leftDrivetrainMasterID = 5;
    int leftDrivetrainSlave1ID = 6;
    int leftDrivetrainSlave2ID = 7;
    int rightDrivetrainMasterID = 3;
    int rightDrivetrainSlave1ID = 4;
    int rightDrivetrainSlave2ID = 8;
    int liftMotor1ID = 49;
    int liftMotor2ID = 39;
    int liftMotor3ID = 29;
    int liftMotor4ID = 19;
    int armTalonID = -1;

    int leftDrivetrainMasterPDPSlot = 0;
    int leftDrivetrainSlave1PDPSlot = 0;
    int leftDrivetrainSlave2PDPSlot = 0;
    int rightDrivetrainMasterPDPSlot = 0;
    int rightDrivetrainSlave1PDPSlot = 0;
    int rightDrivetrainSlave2PDPSlot = 0;
    int liftMotor1PDPSlot = 0;
    int liftMotor2PDPSlot = 0;
    int liftMotor3PDPSlot = 0;
    int liftMotor4PDPSlot = 0;
    int armTalonPDPSlot = 0;

    int limitSwitchLiftBottomPort = 0;
    int limitSwitchLiftTopPort = 1;

    int intakeTiltPotPort = 0;

    SPI.Port gyroPort = SPI.Port.kOnboardCS0;

    int gamepad1Port = 0;
    int gamepad2Port = 1;

    //Gamepad Axes and Buttons
    int LEFT_X_AXIS = 0;
    int LEFT_Y_AXIS = 1;
    int LEFT_T_AXIS = 2;
    int RIGHT_T_AXIS = 3;
    int RIGHT_X_AXIS = 4;
    int RIGHT_Y_AXIS = 5;

    int BTN_A = 1;
    int BTN_B = 2;
    int BTN_X = 3;
    int BTN_Y = 4;
    int BTN_LB = 5;
    int BTN_RB = 6;
    int BTN_BACK = 7;
    int BTN_START = 8;
    int BTN_LEFT_JOYSTICK = 9;
    int BTN_RIGHT_JOYSTICK = 10;

    int DPAD_NOT_PRESSED = -1;

    int DPAD_NORTH = 0;
    int DPAD_NORTHEAST = 45;
    int DPAD_EAST = 90;
    int DPAD_SOUTHEAST = 135;
    int DPAD_SOUTH = 180;
    int DPAD_SOUTHWEST = 225;
    int DPAD_WEST = 270;
    int DPAD_NORTHWEST = 315;

    double LIFT_TOP = 0.0106;
    double LIFT_BOTTOM = .615;

    double LIFT_DISTANCE = LIFT_TOP - LIFT_BOTTOM;

    double kfDriveTrainVel = .687;
    double kpDriveTrainVel = 0.0842;
    double kiDriveTrainVel = 0.0;
    double kdDriveTrainVel = 0;

    double kfDriveTrainPos = 0.05;
    double kpDriveTrainPos = 0.08;
    double kiDriveTrainPos = 0.0;
    double kdDriveTrainPos = 0;

    double kfDriveTrainPos2 = 0.01;
    double kpDriveTrainPos2 = 0.454000254;
    double kiDriveTrainPos2 = 0.0;
    double kdDriveTrainPos2 = 0;

    double turnKp = 0.025;
    double turnKi = 0.0;
    double turnKd = 0.0;
    double turnIDamper = 1.0;

    double turnPOMKp = 0.05;
    double turnPOMKi = 0.0000000015;
    double turnPOMKd = 0.0;
    double turnPOMIDamper = 1.0;

    double gyroDrivePOMKP = 0.05;
    double gyroDrivePOMKI = 0.00005;
    double gyroCorrectionKP = 0.05;
    double gyroCorrectionKI = 0;


    double angleTolerance = 0.5;

    int maxRPM = 1250;

    float NOMINAL_OUTPUT_VOLTAGE = 0.0f;
    float PEAK_OUTPUT_VOLTAGE = 12.0f;
    int ANALOG_OUTPUT_VOLTAGE = 5;

    int RANGE_VOLTAGE_CONSTANT = 5021;

    int ENCODER_PPR = 256;
    int NATIVE_PER_ROTATION = ENCODER_PPR * 4;
    double WHEEL_DIAMETER = 4.0;
    double CLICKS_PER_INCH = (NATIVE_PER_ROTATION) / (WHEEL_DIAMETER * Math.PI);
    double VOLTS_PER_MM = (ANALOG_OUTPUT_VOLTAGE / RANGE_VOLTAGE_CONSTANT);





    //BIG BRAIN STARTS HERE

    /* ROBOT PHYSICAL CONSTANTS */

    // Wheels
    // double kDriveWheelDiameterInches = 4.875;	//Practice bot calibrated 4.875
     double kDriveWheelDiameterInches = 5;	//Comp bot measured val
    // double kDriveWheelDiameterInches = PathAdapter.getAdaptedWheelDiameter();
     double kTrackWidthInches = 25.5;
     double kTrackScrubFactor = 1.0; // 0.924 ?

    // Geometry
     double kCenterToFrontBumperDistance = 18.75;
     double kCenterToIntakeDistance = 18.75;
     double kCenterToRearBumperDistance = 18.75;
     double kCenterToSideBumperDistance = 16.375;

    // Path following constants
     double kMinLookAhead = 12.0; // inches
     double kMinLookAheadSpeed = 9.0; // inches per second
     double kMaxLookAhead = 24.0; // inches
     double kMaxLookAheadSpeed = 140.0; // inches per second
     double kDeltaLookAhead = kMaxLookAhead - kMinLookAhead;
     double kDeltaLookAheadSpeed = kMaxLookAheadSpeed - kMinLookAheadSpeed;

     double kInertiaSteeringGain = 0.0; // angular velocity command is multiplied by this gain *
    // our speed
    // in inches per sec
     double kSegmentCompletionTolerance = 1; // inches
     double kPathFollowingMaxAccel = 100.0; // inches per second^2
     double kPathFollowingMaxVel = 140.0; // inches per second

     double kPathFollowingProfileKp = 5.0;   //Used to be 5 when tuning our paths
     double kPathFollowingProfileKi = 0.03;
     double kPathFollowingProfileKv = 0.2;
     double kPathFollowingProfileKffv = 1.0;
     double kPathFollowingProfileKffa = 0.05;
     double kPathFollowingGoalPosTolerance = 1;
     double kPathFollowingGoalVelTolerance = 18.0;
     double kPathStopSteeringDistance = 9.0;
     double kMaxTrackerDistance = 18.0;
     double kMaxGoalTrackAge = 1.0;
     double kCameraFrameRate = 30.0;

    //Thread prioritization - 5 is default
     int kRobotThreadPriority = 9;
     int kLooperThreadPriority = Thread.MAX_PRIORITY;
     int kCriticalSystemsMonitorThreadPriority = 8;
     int kConnectionMonitorThreadPriority = 7;
     int kLEDThreadPriority = Thread.MIN_PRIORITY;
     int kConsoleReporterThreadPriority = Thread.NORM_PRIORITY;
     int kDashboardReporterThreadPriority = 6;
     double kLooperDt = 0.005;
     double kSensorUnitsPerRotation = 4096.0;
     double k100msPerMinute = 600.0;

     int kTimeoutMs = 20;
     int kTimeoutMsFast = 10;
     int kActionTimeoutS = 2;
     int kTalonRetryCount = 3;

    /* CONTROL LOOP GAINS */

    // PID gains for drive velocity loop (HIGH GEAR)
    // Units: setpoint, error, and output are in inches per second.
    // UNTUNED
    double kDriveHighGearVelocityKp = 1;
    double kDriveHighGearVelocityKi = 0.005;
    double kDriveHighGearVelocityKd = 1.6;
    double kDriveHighGearVelocityKf = 0.165;
    int kDriveHighGearVelocityIZone = 0;
    double kDriveHighGearVelocityRampRate = 0.1;
    double kDriveHighGearMaxSetpoint = 12.0 * 12.0; // 12 fps

    double kCameraXOffset = -3.3211;
	double kCameraYOffset = 0.0;
	double kCameraZOffset = 20.9;
	double kCameraPitchAngleDegrees = 29.56; // Measured on 4/26
	double kCameraYawAngleDegrees = 0.0;
    double kCameraDeadband = 0.0;
    
    double kBoilerTargetTopHeight = 88.0;
	double kBoilerRadius = 7.5;

	int kElevatorUpRateSlot = 0;
    int kElevatorDownRateSlot = 1;
    int kArmNormalRateSlot = 0;
    int kArmFastRateSlot = 1;

    double kArmKp = 0/*6.7*/;
    double kArmKi = 0;
    double kArmKd = 0/*11*/;
    double kArmKf = 0/*1*/;
    int kArmIZone = 0;
    double kArmRampRate = 0;
    int kArmMaxVelocity = 450;
    int kArmMaxAccel = 200;
    int kArmMaxAccelDownFast = 350;
    int kArmAllowedError = (int)(0 * kSensorUnitsPerRotation);
    double kArmFinalRotationsPerDegree = 0/*kArmArmPulley/kArmMotorPulley/360.0*/;
    double kArmSoftMin = 0 * kArmFinalRotationsPerDegree;
    double kArmSoftMax = 175 * kArmFinalRotationsPerDegree;
    double kArmEncoderGearRatio = 1.0;
    int kArmMotorPDPBreakerRating = 30;
    int kArmMaxContinuousCurrentLimit = kArmMotorPDPBreakerRating;
    int kArmMaxPeakCurrentLimit = kArmMaxContinuousCurrentLimit * 2;
    int kArmMaxPeakCurrentDurationMS = getMSDurationForBreakerLimit(kArmMaxPeakCurrentLimit, kArmMaxContinuousCurrentLimit);

    double kPDPBreakerModelA = 282.2962;
    double kPDPBreakerModelB = -6.6305;
    double kPDPBreakerModelC = 0.5;
    double kPDPDefaultSafetyFactor = 4.0;

    private static int getMSDurationForBreakerLimit(double peakCurrentInput, double breakerRating) {
        return getMSDurationForBreakerLimit(peakCurrentInput, breakerRating, kPDPDefaultSafetyFactor);
    }

    private static int getMSDurationForBreakerLimit(double peakCurrentInput, double breakerRating, double safetyFactor) {
        return (int)((kPDPBreakerModelA*Math.pow(peakCurrentInput/breakerRating, kPDPBreakerModelB)+kPDPBreakerModelC) * 1000.0 / safetyFactor);
    }



}
