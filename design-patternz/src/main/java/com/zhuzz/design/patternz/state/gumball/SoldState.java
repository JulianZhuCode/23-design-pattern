package com.zhuzz.design.patternz.state.gumball;

import com.zhuzz.design.lab.i18n.Messages;

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
        Messages.println("gumball.pleaseWaitDispensing");
    }

    @Override
    public void ejectQuarter() {
        Messages.println("gumball.tooLateCrankTurned");
    }

    @Override
    public void turnCrank() {
        Messages.println("gumball.turningTwiceDoesNotHelp");
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