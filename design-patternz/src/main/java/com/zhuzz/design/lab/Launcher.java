package com.zhuzz.design.lab;

import com.zhuzz.design.lab.ui.LauncherApp;

import javax.swing.SwingUtilities;

/**
 * 程序启动入口：在 EDT（Swing 事件分发线程）上创建并显示主窗口。
 * 单独放在 lab 根包，避免启动逻辑埋进 UI 子包。
 * Application entry point: creates and shows the main window on the EDT.
 * Lives in the lab root package so the bootstrap isn't buried in the UI subpackage.
 */
public final class Launcher {

    private Launcher() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LauncherApp().setVisible(true));
    }
}