package com.qatommy.interview.isprime;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IsPrimeTest {
    @Test
    public void testCanGetListOfPrimes() {
        int expectedSize = 25;
        List<Integer> firstNPrimes = IsPrime.findFirstNPrimes(expectedSize);
        for (Integer n : firstNPrimes) {
            System.out.println(n + ",");
        }
        assertEquals("Failed asserting the output list contained the expected number of elements.", expectedSize, firstNPrimes.size());
    }

    @Test
    public void testOneIsPrime() throws Exception {
        int n = 1;
        assertTrue("Failed asserting " + n + " is a prime number.", IsPrime.isPrime(n));
    }

    @Test
    public void testTwoIsPrime() throws Exception {
        int n = 2;
        assertTrue("Failed asserting " + n + " is a prime number.", IsPrime.isPrime(n));
    }

    @Test
    public void testThreeIsPrime() throws Exception {
        int n = 3;
        assertTrue("Failed asserting " + n + " is a prime number.", IsPrime.isPrime(n));
    }

    @Test
    public void testFourIsNotPrime() throws Exception {
        int n = 4;
        assertTrue("Failed asserting " + n + " is not a prime number.", !IsPrime.isPrime(n));
    }

    @Test
    public void testFiveIsPrime() throws Exception {
        int n = 5;
        assertTrue("Failed asserting " + n + " is a prime number.", IsPrime.isPrime(n));
    }

    @Test
    public void testSixIsNotPrime() throws Exception {
        int n = 6;
        assertTrue("Failed asserting " + n + " is not a prime number.", !IsPrime.isPrime(n));
    }

    @Test
    public void testPrimesTo100() throws Exception {
        for (Integer n : knownPrimes) {
            assertTrue("Failed asserting " + n + " is a prime number.", IsPrime.isPrime(n));
        }
    }

    @Test
    public void testNonPrimesTo100() throws Exception {
        for (Integer n : knownNonPrimes) {
            assertTrue("Failed asserting " + n + " not is a prime number.", !IsPrime.isPrime(n));
        }
    }


    List<Integer> knownPrimes = Arrays.asList(
            1, 2, 3, 5, 7,
            11, 13, 17, 19,
            23, 29,
            31, 37,
            41, 43, 47,
            53, 59,
            61, 67,
            71, 73, 79,
            83, 89,
            97
    );

    List<Integer> knownNonPrimes = Arrays.asList(
            4, 6, 8, 9, 10,
            12, 14, 15, 16, 18, 20,
            21, 22, 24, 25, 26, 27, 28, 30,
            32, 33, 34, 35, 36, 38, 39, 40,
            42, 44, 45, 46, 48, 49, 50,
            51, 52, 54, 55, 56, 57, 58, 60,
            62, 63, 64, 65, 66, 68, 69, 70,
            72, 74, 75, 76, 77, 78, 80,
            81, 82, 84, 85, 86, 87, 88, 90,
            91, 92, 93, 94, 95, 96, 98, 99, 100
    );

}
