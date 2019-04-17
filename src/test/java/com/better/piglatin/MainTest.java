package com.better.piglatin;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class MainTest {

    public static void main(String[] args) {
        System.out.println("Running tests");

        JUnitCore engine = new JUnitCore();
        engine.addListener(new TextListener(System.out));
        engine.run(PiglatinApplicationTests.class);
    }
}