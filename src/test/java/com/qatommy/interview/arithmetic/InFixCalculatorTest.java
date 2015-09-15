package com.qatommy.interview.arithmetic;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InFixCalculatorTest {
    @Test
    public void testCompute_expression() throws Exception {
        for (Map.Entry<String, Integer> pair : testValues) {
            String s = pair.getKey();
            int actual = InFixCalculator.evaluate(s);
            int expected = pair.getValue();
            assertEquals("Failed to evaluate the string " + s + " properly.", expected, actual);
        }
    }

    public static final List<Map.Entry<String, Integer>> testValues = Arrays.asList(
            new AbstractMap.SimpleEntry<>("2+2", 4),
            new AbstractMap.SimpleEntry<>("(2+2)", 4),
            new AbstractMap.SimpleEntry<>("(2+2)-4", 0),
            new AbstractMap.SimpleEntry<>("((2+2)-4)", 0),
            new AbstractMap.SimpleEntry<>("(1+2)-4", -1),
            new AbstractMap.SimpleEntry<>("(2+2)-(3-(6-5))-4", -2),
            new AbstractMap.SimpleEntry<>("(3-(6-5))", 2),
            new AbstractMap.SimpleEntry<>("(3-(6-5))-4", -2),
            new AbstractMap.SimpleEntry<>("4-(3-(6-5))-4", -2),
            new AbstractMap.SimpleEntry<>("(2+2)-(3-(6-5))-4", -2)
    );

}
