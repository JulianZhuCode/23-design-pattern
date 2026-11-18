package com.zhuzz.design.patternz.state.elevator;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ElevatorDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_STATE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Elevator State", Locale.SIMPLIFIED_CHINESE, "电梯状态");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        Elevator elevator = new Elevator();

        // 开门：已处于开门状态
        // open: already open
        elevator.openDoors();
        // 开门时无法移动
        // cannot move while open
        elevator.move();
        // 关门
        // close doors
        elevator.closeDoors();
        // 移动
        // move
        elevator.move();
        // 停止
        // stop
        elevator.stop();
        // 开门
        // open doors
        elevator.openDoors();
    }
}