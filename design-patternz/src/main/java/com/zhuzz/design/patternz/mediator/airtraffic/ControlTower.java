package com.zhuzz.design.patternz.mediator.airtraffic;

import com.zhuzz.design.lab.i18n.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者：管制塔，统一调度跑道，避免飞机之间直接协商
 * Concrete mediator: control tower managing the single runway
 */
public class ControlTower implements AirTrafficControl {
    private final List<Airplane> planes = new ArrayList<>();
    private boolean runwayAvailable = true;

    @Override
    public void registerPlane(Airplane plane) {
        planes.add(plane);
    }

    @Override
    public void requestLanding(Airplane plane) {
        if (runwayAvailable) {
            Messages.println("tower.clearToLand", plane.getName());
            runwayAvailable = false;
        } else {
            Messages.println("tower.hold", plane.getName());
        }
    }

    @Override
    public void requestTakeoff(Airplane plane) {
        Messages.println("tower.clearToTakeoff", plane.getName());
        runwayAvailable = true;
    }
}