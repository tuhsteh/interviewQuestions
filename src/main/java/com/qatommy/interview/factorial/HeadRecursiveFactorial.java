package com.qatommy.interview.factorial;

public class HeadRecursiveFactorial {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for values less than zero.");
        }
        if (n == 0) {
            return 1;
        }
        return innerFactorial(n - 1) * n;
    }

    private static int innerFactorial(int i) {
        if (i < 1) {
            return 1;
        }
        return innerFactorial(i - 1) * i;
    }

}

