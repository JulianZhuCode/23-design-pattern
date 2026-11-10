package com.zhuzz.design.patternz.decorator;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class DecoratorDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_DECORATOR; }
    @Override public void run() { CoffeeDecoratorCase.main(new String[0]); }
}