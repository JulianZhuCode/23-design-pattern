package com.zhuzz.design.lab;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

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