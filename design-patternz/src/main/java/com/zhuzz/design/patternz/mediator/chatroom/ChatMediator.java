package com.zhuzz.design.patternz.mediator.chatroom;

/**
 * 中介者接口：负责用户之间消息转发与用户注册
 * Mediator: forwards messages, registers users
 */
public interface ChatMediator {
    void sendMessage(String message, User user);

    void addUser(User user);
}