package com.zhuzz.design.patternz.state.elevator;

/** 电梯状态接口：声明各状态下可执行的动作 | State: declares available actions */
public interface ElevatorState {
    void openDoors();

    void closeDoors();

    void move();

    void stop();
}