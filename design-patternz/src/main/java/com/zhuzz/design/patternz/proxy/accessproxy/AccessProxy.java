package com.zhuzz.design.patternz.proxy.accessproxy;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 代理：校验权限后才允许访问真实资源
 * Proxy: checks permission before accessing the real resource
 */
public class AccessProxy implements Subject {
    private RealResource realResource;
    private String role;

    public AccessProxy(String role) {
        this.role = role;
    }

    @Override
    public void access() {
        if ("admin".equalsIgnoreCase(role)) {
            if (realResource == null) {
                realResource = new RealResource();
            }
            realResource.access();
        } else {
            Messages.println("access.denied", role);
        }
    }
}