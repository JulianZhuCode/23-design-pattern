package com.zhuzz.design.patternz.state.elevator;

/** 具体状态：移动中 | Concrete state: moving */
public class MovingState implements ElevatorState {
    private final Elevator elevator;

    public MovingState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoors() {
        System.out.println("Cannot open doors while moving.");
    }

    @Override
    public void closeDoors() {
        System.out.println("Doors are already closed.");
    }

    @Override
    public void move() {
        System.out.println("Already moving.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping.");
        elevator.setState(new CloseState(elevator));
    }
}