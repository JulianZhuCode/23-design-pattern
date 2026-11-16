package com.zhuzz.design.patternz.proxy.accessproxy;

/**
 * 真实主题：真正访问敏感资源
 * Real subject: actually accesses the sensitive resource
 */
public class RealResource implements Subject {
    @Override
    public void access() {
        System.out.println("Accessing the sensitive resource...");
    }
}