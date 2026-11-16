package com.zhuzz.design.lab.playground;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 描述沙盒案例的一个输入项：唯一标识、多语言标签、类型（下拉/文本）、可选值与默认值。
 * Describes a single playground input: unique id, localized label, type (choice/text),
 * available choices and a default value.
 *
 * @param id           输入项唯一标识 Unique input identifier
 * @param label        标签多语言映射 Localized label mapping
 * @param type         输入类型 Input type (CHOICE or TEXT)
 * @param choices      下拉选项（TEXT 类型时为空） Choices for CHOICE type (empty for TEXT)
 * @param defaultValue 默认值 Default value
 */
public record PlaygroundInput(
        String id,
        Map<Locale, String> label,
        Type type,
        List<String> choices,
        String defaultValue) {

    public enum Type { CHOICE, TEXT }

    /**
     * 按语言取标签，回退链：指定语言 → 英文 → id。
     * Resolve label with fallback: locale → English → id.
     */
    public String label(Locale locale) {
        return label.getOrDefault(locale, label.getOrDefault(Locale.ENGLISH, id));
    }
}