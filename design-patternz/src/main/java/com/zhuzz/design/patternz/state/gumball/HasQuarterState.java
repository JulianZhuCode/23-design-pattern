package com.zhuzz.design.patternz.state.gumball;

/**
 * 具体状态：已有硬币，可退币或转动曲柄
 * Concrete state: quarter inserted
 */
public class HasQuarterState implements GumballState {
    private final GumballMachine machine;

    public HasQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You already inserted a quarter.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned.");
        machine.setState(new NoQuarterState(machine));
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned the crank.");
        machine.setState(new SoldState(machine));
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed yet.");
    }
}