package com.qatommy.interview.isprime;

import java.util.ArrayList;
import java.util.List;

public class IsPrime {

    public static boolean isPrime(int n) {
        boolean isPrime = true;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static List<Integer> findFirstNPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int currentPrime = 1;
        while (primes.size() < n) {
            if(IsPrime.isPrime(currentPrime)) primes.add(currentPrime);
            currentPrime++;
        }
        return primes;
    }
}
