package com.zhuzz.design.patternz.state.gumball;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class GumballDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_STATE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Gumball Machine", Locale.SIMPLIFIED_CHINESE, "糖果机");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "count",
                Map.of(Locale.ENGLISH, "Candy Count", Locale.SIMPLIFIED_CHINESE, "糖果数量"),
                PlaygroundInput.Type.TEXT,
                List.of(),
                "2"));
    }

    @Override public void run(Map<String, String> values) {
        // 按用户输入的初始糖果数量创建机器，观察状态随操作流转
        // create the machine with the user-provided candy count and watch states transition
        int count;
        try {
            count = Integer.parseInt(values.getOrDefault("count", "2"));
        } catch (NumberFormatException e) {
            Messages.println("gumball.invalidCount");
            return;
        }
        GumballMachine machine = new GumballMachine(count);

        machine.insertQuarter();
        machine.turnCrank();

        machine.insertQuarter();
        machine.ejectQuarter();
        machine.insertQuarter();
        machine.turnCrank();

        // 此时糖果已售罄
        // sold out now
        machine.insertQuarter();
    }
}