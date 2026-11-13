package com.zhuzz.design.lab;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * 运行 Runnable 并捕获其 System.out 输出。
 * Captures System.out output of a Runnable.
 * <p>
 * 注意：会临时替换全局 System.out（全局副作用），且仅捕获 stdout（不含 stderr）；
 * 方法非线程安全，请勿并发调用；返回前会 trim 首尾空白。
 * Note: temporarily replaces the global System.out, captures stdout only (not stderr),
 * is not thread-safe, and trims leading/trailing whitespace.
 */
public class OutputCapture {

    public static String capture(Runnable runner) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream captured = new PrintStream(baos, true, StandardCharsets.UTF_8);
        System.setOut(captured);
        try {
            runner.run();
            captured.flush();
            return baos.toString(StandardCharsets.UTF_8).trim();
        } finally {
            System.setOut(originalOut);
        }
    }
}