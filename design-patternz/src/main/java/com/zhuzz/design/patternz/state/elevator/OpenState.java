package com.zhuzz.design.patternz.state.elevator;

/** 具体状态：开门，负责本状态下的行为与状态迁移 */
public class OpenState implements ElevatorState {
    private final Elevator elevator;

    public OpenState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoors() {
        System.out.println("Doors are already open.");
    }

    @Override
    public void closeDoors() {
        System.out.println("Closing doors.");
        elevator.setState(new CloseState(elevator));
    }

    @Override
    public void move() {
        System.out.println("Cannot move while doors are open.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping while doors are open.");
    }
}