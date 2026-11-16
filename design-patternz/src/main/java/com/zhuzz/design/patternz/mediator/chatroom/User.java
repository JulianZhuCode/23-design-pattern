package com.zhuzz.design.patternz.mediator.chatroom;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 用户：通过中介者与其他用户通信
 * Colleague: communicates via mediator
 */
public class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        Messages.println("user.send", name, message);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        Messages.println("user.receive", name, message);
    }
}