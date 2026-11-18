package com.zhuzz.design.patternz.mediator.chatroom;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 中介者模式演示：用户通过聊天室互相发消息
 * Mediator demo: users chat via a room
 */
public class ChatRoomDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_MEDIATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Chat Room", Locale.SIMPLIFIED_CHINESE, "聊天室");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(
                new PlaygroundInput(
                        "sender",
                        Map.of(Locale.ENGLISH, "Sender", Locale.SIMPLIFIED_CHINESE, "发送者"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("Alice", "Bob", "Charlie"),
                        "Alice"),
                new PlaygroundInput(
                        "message",
                        Map.of(Locale.ENGLISH, "Message", Locale.SIMPLIFIED_CHINESE, "消息"),
                        PlaygroundInput.Type.TEXT,
                        List.of(),
                        "大家好！"));
    }

    @Override public void run(Map<String, String> values) {
        ConcreteChatMediator chatMediator = new ConcreteChatMediator();

        User alice = new User("Alice", chatMediator);
        User bob = new User("Bob", chatMediator);
        User charlie = new User("Charlie", chatMediator);

        chatMediator.addUser(alice);
        chatMediator.addUser(bob);
        chatMediator.addUser(charlie);

        // 按用户选择的发送者与消息，观察聊天室如何广播给其他用户
        // broadcast the user-selected message from the chosen sender via the mediator
        String sender = values.getOrDefault("sender", "Alice");
        String message = values.getOrDefault("message", "大家好！");
        switch (sender) {
            case "Bob" -> bob.sendMessage(message);
            case "Charlie" -> charlie.sendMessage(message);
            default -> alice.sendMessage(message);
        }
    }
}