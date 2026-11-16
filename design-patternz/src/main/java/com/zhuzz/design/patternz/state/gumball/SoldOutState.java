package com.zhuzz.design.patternz.state.gumball;

import com.zhuzz.design.lab.i18n.Messages;

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
        Messages.println("gumball.soldOut");
    }

    @Override
    public void ejectQuarter() {
        Messages.println("gumball.noQuarterToEject");
    }

    @Override
    public void turnCrank() {
        Messages.println("gumball.soldOut");
    }

    @Override
    public void dispense() {
        Messages.println("gumball.noGumball");
    }
}