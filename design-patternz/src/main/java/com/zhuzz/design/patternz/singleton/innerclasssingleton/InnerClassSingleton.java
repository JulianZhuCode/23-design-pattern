package com.zhuzz.design.patternz.singleton.innerclasssingleton;

/**
 * 单例模式 - 静态内部类实现
 *
 * <p>通过私有静态内部类 Holder 持有唯一实例，由 JVM 保证类加载时的线程安全，
 * 并在首次调用 {@link #getInstance()} 时才完成初始化，实现懒加载。</p>
 *
 * @author zhuzz
 */
public class InnerClassSingleton {

    /** 私有构造方法，禁止外部直接实例化 */
    private InnerClassSingleton() {
        // 初始化操作
    }

    /** 获取单例实例（首次调用时由 Holder 完成初始化） */
    public static InnerClassSingleton getInstance() {
        return Holder.INSTANCE;
    }

    /** 演示用成员方法 */
    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }

    /** 静态内部类：利用类加载机制保证线程安全，并实现懒加载 */
    private static class Holder {
        static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}