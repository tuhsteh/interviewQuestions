package com.qatommy.interview.arithmetic;

import com.sun.tools.javac.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InFixCalculatorTest {
    @Test
    public void testCompute_expression() throws Exception {
        for (Pair<String, Integer> pair : testValues) {
            String s = pair.fst;
            int actual = InFixCalculator.evaluate(s);
            int expected = pair.snd;
            assertEquals("Failed to evaluate the string " + s + " properly.", expected, actual);
        }
    }

    public static final List<Pair<String, Integer>> testValues = Arrays.asList(
            new Pair<>("2+2", 4),
            new Pair<>("(2+2)", 4),
            new Pair<>("(2+2)-4", 0),
            new Pair<>("((2+2)-4)", 0),
            new Pair<>("(1+2)-4", -1),
            new Pair<>("(2+2)-(3-(6-5))-4", -2),
            new Pair<>("(3-(6-5))", 2),
            new Pair<>("(3-(6-5))-4", -2),
            new Pair<>("4-(3-(6-5))-4", -2),
            new Pair<>("(2+2)-(3-(6-5))-4", -2)
    );

}
