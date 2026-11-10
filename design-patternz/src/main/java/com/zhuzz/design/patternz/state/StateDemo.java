package com.zhuzz.design.patternz.state;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class StateDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_STATE; }
    @Override public void run() { ElevatorCase.main(new String[0]); }
}