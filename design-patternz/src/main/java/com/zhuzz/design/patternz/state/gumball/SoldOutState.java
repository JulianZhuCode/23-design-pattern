package com.zhuzz.design.patternz.state.gumball;

/**
 * 具体状态：售罄，所有动作均无效
 * Concrete state: sold out
 */
public class SoldOutState implements GumballState {
    private final GumballMachine machine;

    public SoldOutState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Sold out.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter to eject.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sold out.");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball.");
    }
}