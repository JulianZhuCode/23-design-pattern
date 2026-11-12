package com.zhuzz.design.patternz.state.elevator;

/** 电梯上下文：持有当前状态，仅将动作委托给状态对象，状态迁移由状态对象负责 */
public class Elevator {
    private ElevatorState state;

    public Elevator() {
        state = new CloseState(this); // 初始状态为关门状态
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