package com.zhuzz.design.patternz.state.elevator;

/** 具体状态：关门 */
public class CloseState implements ElevatorState {
    @Override
    public void openDoors() {
        System.out.println("Opening doors.");
    }

    @Override
    public void closeDoors() {
        System.out.println("Doors are already closed.");
    }

    @Override
    public void move() {
        System.out.println("Start moving.");
    }

    @Override
    public void stop() {
        System.out.println("Already stopped.");
    }
}