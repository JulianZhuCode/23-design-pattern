package com.zhuzz.design.patternz.facade.hometheater;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 外观：统一封装观影所需的多个子系统操作
 * Facade: wraps subsystem operations for movie watching
 */
public class HomeTheaterFacade {
    private StereoSystem stereo;
    private Projector projector;
    private LightsControl lights;

    public HomeTheaterFacade() {
        stereo = new StereoSystem();
        projector = new Projector();
        lights = new LightsControl();
    }

    public void watchMovie() {
        Messages.println("homeTheater.watch");
        lights.turnOff();
        projector.turnOn();
        stereo.turnOn();
    }

    public void endMovie() {
        Messages.println("homeTheater.end");
        stereo.turnOff();
        projector.turnOff();
        lights.turnOn();
    }
}