package com.zhuzz.design.patternz.proxy.accessproxy;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 真实主题：真正访问敏感资源
 * Real subject: actually accesses the sensitive resource
 */
public class RealResource implements Subject {
    @Override
    public void access() {
        Messages.println("access.granted");
    }
}