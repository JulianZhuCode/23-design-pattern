package com.zhuzz.design.patternz.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式 - 聊天室案例
 *
 * @author zhuzz
 * 2023/8/29 17:50
 */
public class ChatRoomCase {

    public static void main(String[] args) {
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

    interface ChatMediator {
        void sendMessage(String message, User user);

        void addUser(User user);
    }

    static class ConcreteChatMediator implements ChatMediator {
        private List<User> users = new ArrayList<>();

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

    static class User {
        private String name;
        private ChatMediator mediator;

        public User(String name, ChatMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        public void sendMessage(String message) {
            System.out.println(name + " 发送消息: " + message);
            mediator.sendMessage(message, this);
        }

        public void receiveMessage(String message) {
            System.out.println(name + " 收到消息: " + message);
        }
    }


}