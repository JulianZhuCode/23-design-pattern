package com.zhuzz.design.patternz.state.elevator;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体状态：移动中
 * Concrete state: moving
 */
public class MovingState implements ElevatorState {
    private final Elevator elevator;

    public MovingState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoors() {
        Messages.println("elevator.cannotOpenWhileMoving");
    }

    @Override
    public void closeDoors() {
        Messages.println("elevator.doorsAlreadyClosed");
    }

    @Override
    public void move() {
        Messages.println("elevator.alreadyMoving");
    }

    @Override
    public void stop() {
        Messages.println("elevator.stopping");
        elevator.setState(new CloseState(elevator));
    }
}