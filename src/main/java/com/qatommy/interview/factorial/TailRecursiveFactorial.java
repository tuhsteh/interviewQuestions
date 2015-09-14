package com.qatommy.interview.factorial;

public class TailRecursiveFactorial {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for values less than zero.");
        }
        if (n == 0) {
            return 1;
        }
        return n * innerFactorial(n - 1);
    }

    private static int innerFactorial(int i) {
        if (i < 1) {
            return 1;
        }
        return i * innerFactorial(i - 1);
    }

}

