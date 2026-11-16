package com.zhuzz.design.patternz.memento.gamesave;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人：存档管理器，保管多个存档但不修改其内容
 * Caretaker: keeps multiple saves without modifying
 */
public class SaveManager {
    private final List<GameState> saves = new ArrayList<>();

    public void save(GameState memento) {
        saves.add(memento);
    }

    public GameState get(int index) {
        return saves.get(index);
    }
}