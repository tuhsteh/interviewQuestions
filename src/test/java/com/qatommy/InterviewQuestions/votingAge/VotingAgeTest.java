package com.qatommy.InterviewQuestions.votingAge;

/**
 * Provided as a coding exercise by Benjamin Texier @ CB.
 * Several problems here:
 * 1. converting input values
 * 2. checking for bad inputs
 * 3. checking for invalid inputs
 * 4. proper error messages
 * 5. reasoning about whether zero / other proper numeric values are valid
 * 6. when considering use as part of a larger API, does messaging make sense vs raising exceptions
 */
public class VotingAgeTest {

    public static void main(String[] args) {
        char[][] testValues = {
                null,
                {},  // Empty value:  CAUGHT ERROR WITH MESSAGE
                ("-10" + String.valueOf(Integer.MAX_VALUE)).toCharArray(), // more than max negative:  ERROR
                {'-', '1', '9'},  // negative:  ERROR MESSAGE
                {'+', '1', '9'},  // explicitly positive:  TRUE
                {'9'},    // not old enough:  FALSE
                {'0', '9'}, // not old enough, but leading zero:  FALSE
                {'0', 'x', '1', 'e'}, // a hex value representation:  CAUGHT ERROR WITH MESSAGE
                {'0', 'x', '2', '5'}  // another hex value representation:  CAUGHT ERROR WITH MESSAGE
        };

        for (char[] testValue : testValues) {
            if (null != testValue) {
                System.out.println("Given input [" + String.valueOf(testValue) + "], ");
                boolean canVote = canVote(testValue);
                System.out.println("This person can vote: " + (canVote ? "yes" : "no"));
            } else {
                System.out.println("Bad input value");
            }
            System.out.println();  // space out the output blocks for readability.
        }
    }

    /**
     * Tell whether or not this person is old enough to vote (18 and older)
     *
     * @param age of the person
     * @return boolean
     */
    private static boolean canVote(char[] age) {
        int ageInt = 0;
        String str = "";
        try {
            str = String.valueOf(age);
            System.out.println(String.format("Age String:  [%s]", str));
            ageInt = Integer.parseInt(str);
            System.out.println(String.format("Age int:  [%d]", ageInt));
            if (ageInt < 0) {  // could also be <= 0 depending on cultural views of age.
                System.out.println("age should not be a negative value: " + ageInt);
            }
            // no check for upper limit, because how does one
            // decide if a person is Too OLD to vote?
            // in the future, or in some jurisdictions,
            // there may actually be upper limits,
            // legally, practically, or otherwise.
        } catch (NumberFormatException e) {
            System.out.printf("There was an issue converting the input value:  [%s]%n", str);
            System.out.println(e.getMessage());
        }
        return (ageInt >= 18);
    }
}

// https://app.coderpad.io/CZQMTGT7

///*
// * Click `Run` to execute the snippet below!
// */
//
//import java.io.*;
//import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
//
//class Solution {
//    public static void main(String[] args) {
//
//        char[] testValue = { '1', '7' };
//
//        boolean canVote = canVote(testValue);
//        System.out.println("This person can vote: " + (canVote ? "yes" : "no"));
//    }
//
//    /**
//     * Tell whether or not this person is old enough to vote (18 and older)
//     *
//     * @param age of the person
//     * @return boolean
//     */
//    private static boolean canVote(char[] age) {
//        //TODO:  fill in method logic
//        return false;
//    }
//
//}
