package com.zhuzz.design.patternz.mediator.airtraffic;

/**
 * 中介者接口：负责飞机注册与起降协调
 * Mediator: registers planes, coordinates landing/takeoff
 */
public interface AirTrafficControl {
    void registerPlane(Airplane plane);

    void requestLanding(Airplane plane);

    void requestTakeoff(Airplane plane);
}