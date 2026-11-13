package com.zhuzz.design.patternz.singleton.innerclasssingleton;

/**
 * 单例模式：静态内部类实现
 * 私有静态内部类 Holder 持有唯一实例，类加载保证线程安全，首次调用 getInstance() 时才初始化，实现懒加载。
 * Singleton via static inner class
 * The private static Holder owns the instance; class loading guarantees thread safety and lazy initialization on first call.
 */
public class InnerClassSingleton {

    /**
     * 私有构造：禁止外部实例化
     * Private ctor prevents direct instantiation
     */
    private InnerClassSingleton() {
    }

    /**
     * 获取单例实例，首次调用时初始化
     * Get the singleton, lazily initialized
     */
    public static InnerClassSingleton getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 演示方法
     * Demo method
     */
    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }

    /**
     * 静态内部类：类加载保证线程安全并实现懒加载
     * Holder ensures thread safety + lazy init
     */
    private static class Holder {
        static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}