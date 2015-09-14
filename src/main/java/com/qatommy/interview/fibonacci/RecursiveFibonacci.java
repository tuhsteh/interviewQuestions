package com.qatommy.interview.fibonacci;

public class RecursiveFibonacci {

    public static void printFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(innerFib(i));
        }
    }

    private static int innerFib(int i) {
        if (i == 0) {
            return 1;
        }
        if (i <= 2) {
            return i;
        }
        return innerFib(i - 1) + innerFib(i - 2);
    }
}
