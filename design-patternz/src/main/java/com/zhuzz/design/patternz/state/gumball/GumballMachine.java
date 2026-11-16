package com.zhuzz.design.patternz.state.gumball;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 糖果机上下文：持有当前状态并把动作委托给状态对象
 * Context: holds state, delegates actions
 */
public class GumballMachine {
    private GumballState state;
    private int count;

    public GumballMachine(int count) {
        this.count = count;
        // 初始状态：有糖则等待投币，否则售罄
        // initial: no-quarter if stocked, else sold-out
        this.state = count > 0 ? new NoQuarterState(this) : new SoldOutState(this);
    }

    public void setState(GumballState state) {
        this.state = state;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        if (count > 0) {
            count--;
            Messages.println("gumball.ballComesOut");
        }
    }

    public int getCount() {
        return count;
    }
}