package com.zhuzz.design.patternz.state.gumball;

/**
 * 具体状态：售出中，转动曲柄后出货
 * Concrete state: dispensing
 */
public class SoldState implements GumballState {
    private final GumballMachine machine;

    public SoldState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, dispensing.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Too late, crank turned.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice does not help.");
    }

    @Override
    public void dispense() {
        machine.releaseBall();
        if (machine.getCount() > 0) {
            machine.setState(new NoQuarterState(machine));
        } else {
            machine.setState(new SoldOutState(machine));
        }
    }
}