package com.zhuzz.design.patternz.state.gumball;

/**
 * 具体状态：无硬币，等待投币
 * Concrete state: no quarter inserted
 */
public class NoQuarterState implements GumballState {
    private final GumballMachine machine;

    public NoQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted.");
        machine.setState(new HasQuarterState(machine));
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter to eject.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Insert a quarter first.");
    }

    @Override
    public void dispense() {
        System.out.println("Insert a quarter first.");
    }
}