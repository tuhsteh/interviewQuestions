package com.qatommy.InterviewQuestions.collectionPerformance;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public abstract class CollectionPerformanceTest {

    public static final int MAX_ITEMS = 50_000;
    public static final int LOOKUP_COUNT = 1_000;
    public static final int STRING_LENGTH = 50;
    public static final Random R = new Random();

    public static String makeARandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
