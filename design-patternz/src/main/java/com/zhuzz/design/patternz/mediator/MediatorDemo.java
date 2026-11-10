package com.zhuzz.design.patternz.mediator;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class MediatorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_MEDIATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Chat Room", Locale.SIMPLIFIED_CHINESE, "聊天室");
    }
    @Override public void run() { ChatRoomCase.main(new String[0]); }
}