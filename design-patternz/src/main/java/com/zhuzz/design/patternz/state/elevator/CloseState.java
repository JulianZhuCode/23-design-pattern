package com.zhuzz.design.patternz.state.elevator;

/** 具体状态：关门，负责本状态下的行为与状态迁移 */
public class CloseState implements ElevatorState {
    private final Elevator elevator;

    public CloseState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoors() {
        System.out.println("Opening doors.");
        elevator.setState(new OpenState(elevator));
    }

    @Override
    public void closeDoors() {
        System.out.println("Doors are already closed.");
    }

    @Override
    public void move() {
        System.out.println("Start moving.");
        elevator.setState(new MovingState(elevator));
    }

    @Override
    public void stop() {
        System.out.println("Already stopped.");
    }
}