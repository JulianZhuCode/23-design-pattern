package com.zhuzz.design.patternz.mediator.airtraffic;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 同事：飞机，只通过塔台沟通，不直接联系其他飞机
 * Colleague: airplane, talks only to the tower
 */
public class Airplane {
    private final String name;
    private final AirTrafficControl control;

    public Airplane(String name, AirTrafficControl control) {
        this.name = name;
        this.control = control;
    }

    public String getName() {
        return name;
    }

    public void requestLanding() {
        Messages.println("airplane.requestLanding", name);
        control.requestLanding(this);
    }

    public void requestTakeoff() {
        Messages.println("airplane.requestTakeoff", name);
        control.requestTakeoff(this);
    }
}