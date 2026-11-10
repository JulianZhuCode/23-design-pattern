package com.zhuzz.design.patternz.state.elevator;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ElevatorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_STATE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Elevator State", Locale.SIMPLIFIED_CHINESE, "电梯状态");
    }
    @Override public void run() {
        Elevator elevator = new Elevator();

        elevator.openDoors(); // 当前状态：开门
        elevator.move();      // 当前状态：开门，无法移动
        elevator.closeDoors(); // 当前状态：关门
        elevator.move();       // 当前状态：移动中
        elevator.stop();       // 当前状态：停止
        elevator.openDoors();  // 当前状态：开门
    }
}