package com.zhuzz.design.patternz.mediator.chatroom;

import java.util.ArrayList;
import java.util.List;

/** 具体中介者：聊天室，维护用户列表并向其他用户转发消息 */
public class ConcreteChatMediator implements ChatMediator {
    private final List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}