package com.zhuzz.design.patternz.state.elevator;

/**
 * 电梯上下文：持有当前状态并把动作委托给状态对象
 * Context: holds state, delegates actions
 */
public class Elevator {
    private ElevatorState state;

    public Elevator() {
        state = new CloseState(this); // 初始状态：关门 | initial: doors closed
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public void openDoors() {
        state.openDoors();
    }

    public void closeDoors() {
        state.closeDoors();
    }

    public void move() {
        state.move();
    }

    public void stop() {
        state.stop();
    }
}