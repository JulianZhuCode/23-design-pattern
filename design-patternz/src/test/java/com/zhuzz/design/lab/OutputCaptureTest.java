package com.zhuzz.design.lab;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * OutputCapture 的单元测试：验证 System.out 捕获与恢复。
 * Unit tests for OutputCapture: verify System.out capture and restoration.
 */
class OutputCaptureTest {

    /**
     * 捕获单行打印，并去除首尾空白。
     * Captures a single printed line and trims surrounding whitespace.
     */
    @Test
    void capturesPrintedLineAndTrims() {
        assertEquals("hello", OutputCapture.capture(() -> System.out.println("hello")));
    }

    /**
     * 捕获多行输出，行分隔符跟随平台。
     * Captures multiple lines, respecting the platform line separator.
     */
    @Test
    void capturesMultipleLines() {
        String expected = "line1" + System.lineSeparator() + "line2";
        String actual = OutputCapture.capture(() -> {
            System.out.println("line1");
            System.out.println("line2");
        });
        assertEquals(expected, actual);
    }

    /**
     * 空输出返回空字符串。
     * Empty output returns an empty string.
     */
    @Test
    void capturesEmptyOutputAsEmptyString() {
        assertEquals("", OutputCapture.capture(() -> { }));
    }

    /**
     * 捕获结束后应恢复原始 System.out。
     * The original System.out must be restored after capture.
     */
    @Test
    void restoresSystemOut() {
        PrintStream original = System.out;
        OutputCapture.capture(() -> System.out.println("x"));
        assertSame(original, System.out);
    }
}