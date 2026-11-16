package com.zhuzz.design.patternz.memento.gamesave;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class GameSaveDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_MEMENTO; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Game Save", Locale.SIMPLIFIED_CHINESE, "游戏存档");
    }
    @Override public void run() {
        Game game = new Game();
        SaveManager manager = new SaveManager();

        game.setState(1, 100);
        manager.save(game.createMemento());
        System.out.println("Checkpoint 1: " + game);

        game.setState(2, 350);
        manager.save(game.createMemento());
        System.out.println("Checkpoint 2: " + game);

        game.setState(3, 700);
        System.out.println("Current: " + game);

        // 回退到第一个存档
        // restore to the first checkpoint
        game.restoreMemento(manager.get(0));
        System.out.println("Restored: " + game);
    }
}