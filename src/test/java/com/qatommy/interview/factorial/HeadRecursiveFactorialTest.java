package com.qatommy.interview.factorial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeadRecursiveFactorialTest {
    @Test
    public void testFactorial() throws Exception {
        int n = 5;
        long factorial = HeadRecursiveFactorial.factorial(n);
        assertEquals("Failed asserting the factorial method returned the expected value.", 5 * 4 * 3 * 2 * 1, factorial);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegativeInput() throws Exception {
        int n = -5;
        long factorial = HeadRecursiveFactorial.factorial(n);
    }

    @Test
    public void testFactorialInputOfZero() throws Exception {
        int n = 0;
        long factorial = HeadRecursiveFactorial.factorial(n);
        assertEquals("Failed asserting the factorial method returned the expected value.", 1, factorial);
    }
}
