package com.zhuzz.design.patternz.proxy.accessproxy;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class AccessProxyDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_PROXY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Access Control", Locale.SIMPLIFIED_CHINESE, "权限控制");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "role",
                Map.of(Locale.ENGLISH, "Role", Locale.SIMPLIFIED_CHINESE, "角色"),
                PlaygroundInput.Type.CHOICE,
                List.of("admin", "guest"),
                "admin"));
    }

    @Override public void run(Map<String, String> values) {
        // 按用户选择的角色访问，观察代理如何判定权限
        // access with the user-selected role to see how the proxy decides permission
        String role = values.getOrDefault("role", "admin");
        Subject subject = new AccessProxy(role);
        subject.access();
    }
}