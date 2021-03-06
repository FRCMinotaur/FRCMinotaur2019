package frc.robot.Autonomous.StateMachine;

import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

import java.util.List;

public class StateMachineRunner {

    List<AutoStates> states;
    private int currState;
    private int stateDelay;
    private long previousTime = 0;

    public StateMachineRunner(int stateDelay) {
        currState = 0;
        this.stateDelay = stateDelay;
    }

    public StateMachineRunner(List states, int stateDelay) {
        this.states = states;
        this.stateDelay = stateDelay;
        currState = 0;
    }

    public void runStateMachine() {
        if (states != null && currState < states.size() && delayDone()) {
            switch (states.get(currState)) {
                case turn90Clockwise:
                    if (Robot.driveTrain.turnPOM(90, DriveTrain.Direction.CLOCKWISE)) {
                        nextState();
                    }
                    break;
                case turn45Clockwise:
                    if (Robot.driveTrain.turnPID(45, DriveTrain.Direction.CLOCKWISE, 1)) {
                        nextState();
                    }
                    break;
                case turn45CounterClockwise:
                    if (Robot.driveTrain.turnPOM(45, DriveTrain.Direction.COUNTERCLOCKWISE)) {
                        nextState();
                    }
                    break;
                case drive10Inches:
                    if(Robot.driveTrain.moveGyroDistancePOM(10, DriveTrain.Direction.FORWARD, 1, 0)) {
                        nextState();
                    }
                    break;
                case drive1foot:
                    if(Robot.driveTrain.moveGyroDistancePOM(12, DriveTrain.Direction.FORWARD, 1, 0)) {
                        nextState();
                    }
                    break;
                case limelightApproach:
                    if (Robot.driveTrain.limelightApproach(5.0, 12)) {
                        nextState();
                    }
                    break;
            }
        } else {
            System.out.println("States finished or not initialized");
        }
    }

    public void setStates (List states) {
        this.states = states;
        currState = 0;
    }

    public void nextState() {
        currState++;
        previousTime = System.currentTimeMillis();

    }

    public void setStateDelay(int stateDelay) {
        this.stateDelay = stateDelay;
    }

    public int getStateDelay() {
        return stateDelay;
    }

    public boolean delayDone() {
        return System.currentTimeMillis() - previousTime >= stateDelay;
    }
}
