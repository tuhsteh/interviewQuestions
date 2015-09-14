package com.qatommy.interview.factorial;

public class IterativeFactorialWithEmptyForLoop {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for values less than zero.");
        }
        int returnValue = 1;
        for (int i = n; i > 0; returnValue *= i--) {
        }
        return returnValue;
    }

}

