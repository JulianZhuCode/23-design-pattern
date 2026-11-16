package com.zhuzz.design.patternz.state.gumball;

import com.zhuzz.design.lab.i18n.Messages;

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
        Messages.println("gumball.quarterInserted");
        machine.setState(new HasQuarterState(machine));
    }

    @Override
    public void ejectQuarter() {
        Messages.println("gumball.noQuarterToEject");
    }

    @Override
    public void turnCrank() {
        Messages.println("gumball.insertQuarterFirst");
    }

    @Override
    public void dispense() {
        Messages.println("gumball.insertQuarterFirst");
    }
}