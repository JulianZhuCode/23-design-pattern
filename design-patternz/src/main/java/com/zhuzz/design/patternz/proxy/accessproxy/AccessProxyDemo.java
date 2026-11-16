package com.zhuzz.design.patternz.proxy.accessproxy;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class AccessProxyDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_PROXY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Access Control", Locale.SIMPLIFIED_CHINESE, "权限控制");
    }
    @Override public void run() {
        // 管理员角色：允许访问
        // admin role: allowed
        Subject admin = new AccessProxy("admin");
        admin.access();

        // 访客角色：拒绝访问
        // guest role: denied
        Subject guest = new AccessProxy("guest");
        guest.access();
    }
}