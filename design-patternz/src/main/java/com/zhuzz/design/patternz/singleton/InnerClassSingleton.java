package com.zhuzz.design.patternz.singleton;

/**
 * 单例模式 - 静态内部类实现
 *
 * @author zhuzz
 * 2023/8/29 17:33
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
        // 初始化操作
    }

    public static InnerClassSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");

    }

    private static class Holder {
        static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static void main(String[] args) {
        // 获取单例实例
        InnerClassSingleton singleton = InnerClassSingleton.getInstance();

        // 调用成员方法
        singleton.showMessage();
    }


}