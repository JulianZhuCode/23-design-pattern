package com.zhuzz.design.lab.i18n;

/**
 * 统一管理三类信息的枚举：
 * 1) UI 文案 key（LANGUAGE_NAME、BTN_RUN 等）；
 * 2) 模式分类（CAT_*）；
 * 3) 模式 → 分类的归属关系（PAT_*(CAT_*)）。
 * Single enum holding UI message keys, categories (CAT_*), and pattern-to-category mapping.
 */
public enum I18nMessages {

    LANGUAGE_NAME,
    WINDOW_TITLE,
    BTN_RUN,
    BTN_CLEAR,
    OUTPUT_TITLE,
    STATUS_READY,
    STATUS_COUNT,

    CAT_CREATIONAL,
    CAT_STRUCTURAL,
    CAT_BEHAVIORAL,

    PAT_SINGLETON(CAT_CREATIONAL),
    PAT_FACTORY_METHOD(CAT_CREATIONAL),
    PAT_ABSTRACT_FACTORY(CAT_CREATIONAL),
    PAT_BUILDER(CAT_CREATIONAL),
    PAT_PROTOTYPE(CAT_CREATIONAL),

    PAT_ADAPTER(CAT_STRUCTURAL),
    PAT_BRIDGE(CAT_STRUCTURAL),
    PAT_COMPOSITE(CAT_STRUCTURAL),
    PAT_DECORATOR(CAT_STRUCTURAL),
    PAT_FACADE(CAT_STRUCTURAL),
    PAT_FLYWEIGHT(CAT_STRUCTURAL),
    PAT_PROXY(CAT_STRUCTURAL),

    PAT_CHAIN_OF_RESPONSIBILITY(CAT_BEHAVIORAL),
    PAT_COMMAND(CAT_BEHAVIORAL),
    PAT_INTERPRETER(CAT_BEHAVIORAL),
    PAT_ITERATOR(CAT_BEHAVIORAL),
    PAT_MEDIATOR(CAT_BEHAVIORAL),
    PAT_MEMENTO(CAT_BEHAVIORAL),
    PAT_OBSERVER(CAT_BEHAVIORAL),
    PAT_STATE(CAT_BEHAVIORAL),
    PAT_STRATEGY(CAT_BEHAVIORAL),
    PAT_TEMPLATE_METHOD(CAT_BEHAVIORAL),
    PAT_VISITOR(CAT_BEHAVIORAL);

    /**
     * 所属分类：仅 PAT_* 常量有效，其余为 null
     * Category for PAT_* constants only
     */
    private final I18nMessages category;

    I18nMessages() {
        this.category = null;
    }

    I18nMessages(I18nMessages category) {
        this.category = category;
    }

    /**
     * 所属分类：仅 PAT_* 常量有效，其余返回 null，调用方需判空。
     * Category for PAT_* constants only; returns null for others — callers must null-check.
     */
    public I18nMessages category() {
        return category;
    }
}