package com.zhuzz.design.patternz.state.gumball;

import com.zhuzz.design.lab.i18n.Messages;

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
        Messages.println("gumball.alreadyInserted");
    }

    @Override
    public void ejectQuarter() {
        Messages.println("gumball.quarterReturned");
        machine.setState(new NoQuarterState(machine));
    }

    @Override
    public void turnCrank() {
        Messages.println("gumball.turnedCrank");
        machine.setState(new SoldState(machine));
    }

    @Override
    public void dispense() {
        Messages.println("gumball.noGumballDispensedYet");
    }
}