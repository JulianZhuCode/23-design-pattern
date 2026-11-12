package com.zhuzz.design.patternz.mediator.chatroom;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/** 中介者模式演示：用户通过聊天室互相发消息 | Mediator demo: users chat via a room */
public class ChatRoomDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_MEDIATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Chat Room", Locale.SIMPLIFIED_CHINESE, "聊天室");
    }
    @Override public void run() {
        ConcreteChatMediator chatMediator = new ConcreteChatMediator();

        User user1 = new User("Alice", chatMediator);
        User user2 = new User("Bob", chatMediator);
        User user3 = new User("Charlie", chatMediator);

        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);

        user1.sendMessage("大家好！");
        user2.sendMessage("你好，Alice！");
    }
}