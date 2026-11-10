package com.zhuzz.design.patternz.state.elevator;

/** 电梯上下文：持有当前状态，将动作委托给状态对象，并负责状态切换 */
public class Elevator {
    private ElevatorState state;

    public Elevator() {
        state = new CloseState(); // 初始状态为关门状态
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public void openDoors() {
        state.openDoors();
        if (!(state instanceof OpenState)) {
            setState(new OpenState());
        }
    }

    public void closeDoors() {
        state.closeDoors();
        if (!(state instanceof CloseState)) {
            setState(new CloseState());
        }
    }

    public void move() {
        state.move();
        if (state instanceof CloseState) {
            setState(new MovingState());
        }
    }

    public void stop() {
        state.stop();
        if (state instanceof MovingState) {
            setState(new CloseState());
        }
    }
}