package com.zhuzz.design.patternz;

/**
 * 单例模式
 *
 * @author zhuzz
 * 2023/8/29 17:33
 */
public class SingletonPattern {

    private SingletonPattern() {
        // 初始化操作
    }

    public static SingletonPattern getInstance() {
        return Holder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");

    }

    private static class Holder {
        static final SingletonPattern INSTANCE = new SingletonPattern();
    }

    public static void main(String[] args) {
        // 获取单例实例
        SingletonPattern singleton = SingletonPattern.getInstance();

        // 调用成员方法
        singleton.showMessage();
    }


}
