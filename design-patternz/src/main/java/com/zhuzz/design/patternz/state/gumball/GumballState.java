package com.zhuzz.design.patternz.state.gumball;

/**
 * 糖果机状态接口：声明各状态下可执行的动作
 * State: declares available actions
 */
public interface GumballState {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}