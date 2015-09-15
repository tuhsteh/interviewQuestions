package com.qatommy.InterviewQuestions.puzzle;

import org.junit.Test;

public class TypingTests {
    public static final long DAY_IN_MILLIS = 24 * 60 * 60 * 1000;
    public static final long DAY_IN_MICROS = 24 * 60 * 60 * 1000 * 1000;

    @Test
    public void testCompareMicrosToMillis() {
        long compare = DAY_IN_MICROS / DAY_IN_MILLIS;
        System.out.printf("The ratio between Micros and Millis is %d%n", compare);
    }

}
