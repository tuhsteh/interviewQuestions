package com.qatommy.interview.arithmetic;

public class LoopSpeed {

    public static void loop(int limit) {
        long sum = 0L;
        for (int i = 0; i < limit; i++) {
            sum += i;
        }
    }

    public static void main(String[] args) {
        long sum = 0L;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
    }


}
