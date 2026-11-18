package com.zhuzz.design.patternz.memento.gamesave;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class GameSaveDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_MEMENTO; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Game Save", Locale.SIMPLIFIED_CHINESE, "游戏存档");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        Game game = new Game();
        SaveManager manager = new SaveManager();

        game.setState(1, 100);
        manager.save(game.createMemento());
        Messages.println("checkpoint1", game);

        game.setState(2, 350);
        manager.save(game.createMemento());
        Messages.println("checkpoint2", game);

        game.setState(3, 700);
        Messages.println("current", game);

        // 回退到第一个存档
        // restore to the first checkpoint
        game.restoreMemento(manager.get(0));
        Messages.println("restored", game);
    }
}