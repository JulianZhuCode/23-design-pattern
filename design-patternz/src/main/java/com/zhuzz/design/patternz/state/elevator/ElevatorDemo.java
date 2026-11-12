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

        elevator.openDoors(); // 开门：已处于开门状态 | open: already open
        elevator.move();      // 开门时无法移动 | cannot move while open
        elevator.closeDoors(); // 关门 | close doors
        elevator.move();       // 移动 | move
        elevator.stop();       // 停止 | stop
        elevator.openDoors();  // 开门 | open doors
    }
}