package com.qatommy.interview.factorial;

import java.util.List;
import java.util.Arrays;
import java.lang.Integer;

public class LookupFactorial {
    
    static final List<Integer> factorialList = Arrays.asList(
        1,
        1,
        2,
        6,
        24,
        120,
        720,
        5040,
        40320,
        362880,
        3628800,
        39916800,
        479001600
    );

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for values less than zero.");
        }
        return (int) factorialList.get(n);
    }
}
