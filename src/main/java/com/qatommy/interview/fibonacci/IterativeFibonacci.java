package com.qatommy.interview.fibonacci;

public class IterativeFibonacci {

    public static void printFibonacci(int n) {
        int nMinus2 = 0;
        int nMinus1 = 1;
        int curr = 1;
        int i = 0;
        if (n < 0) throw new IllegalArgumentException("Fibonacci is not defined for less than zero elements.");
        while (i++ < n) {
            System.out.println(curr);
            curr = nMinus2 + nMinus1;
            nMinus2 = nMinus1;
            nMinus1 = curr;
        }
    }
}
