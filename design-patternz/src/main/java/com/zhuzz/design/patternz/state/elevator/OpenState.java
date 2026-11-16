package com.zhuzz.design.patternz.state.elevator;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体状态：开门
 * Concrete state: doors open
 */
public class OpenState implements ElevatorState {
    private final Elevator elevator;

    public OpenState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoors() {
        Messages.println("elevator.doorsAlreadyOpen");
    }

    @Override
    public void closeDoors() {
        Messages.println("elevator.closingDoors");
        elevator.setState(new CloseState(elevator));
    }

    @Override
    public void move() {
        Messages.println("elevator.cannotMoveWhileOpen");
    }

    @Override
    public void stop() {
        Messages.println("elevator.stoppingWhileOpen");
    }
}