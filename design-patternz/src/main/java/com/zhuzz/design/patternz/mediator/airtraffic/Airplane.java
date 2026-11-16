package com.zhuzz.design.patternz.mediator.airtraffic;

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
        System.out.println(name + " requests landing.");
        control.requestLanding(this);
    }

    public void requestTakeoff() {
        System.out.println(name + " requests takeoff.");
        control.requestTakeoff(this);
    }
}