package com.zhuzz.design.patternz.state.elevator;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体状态：关门
 * Concrete state: doors closed
 */
public class CloseState implements ElevatorState {
    private final Elevator elevator;

    public CloseState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoors() {
        Messages.println("elevator.openingDoors");
        elevator.setState(new OpenState(elevator));
    }

    @Override
    public void closeDoors() {
        Messages.println("elevator.doorsAlreadyClosed");
    }

    @Override
    public void move() {
        Messages.println("elevator.startMoving");
        elevator.setState(new MovingState(elevator));
    }

    @Override
    public void stop() {
        Messages.println("elevator.alreadyStopped");
    }
}