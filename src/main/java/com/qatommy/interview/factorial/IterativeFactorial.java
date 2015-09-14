package com.qatommy.interview.factorial;

public class IterativeFactorial {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for values less than zero.");
        }
        int returnValue = 1;
        while (n > 0) {
            returnValue *= n--;
        }
        return returnValue;
    }

}

