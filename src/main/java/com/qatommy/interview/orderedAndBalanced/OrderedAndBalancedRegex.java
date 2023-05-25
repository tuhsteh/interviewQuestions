// Write a program to check whether a given string has balanced and ordered parentheses:
// Can assume only 4 different characters are valid: '(', ')', '[', and ']'
// Ex: 
//  (()) -> true
//  (([[[[]]]])(([[]]))) -> true --trs
//  ()[]() -> true
//  (() -> false
//  [()()] -> true
//  [(]  -> false    --trs
//  )() -> false
//  [[[[)))) -> false
//  )( -> false

/* package whatever; // don't place package name! */
package com.qatommy.interview.orderedAndBalanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Name of the class has to be "Main" only if the class is public. */
public class OrderedAndBalancedRegex {
    public static void main(String[] args) {
        System.out.println("First test");
        System.out.println(orderedAndBalanced("[()]"));
        System.out.println("Second test");
        System.out.println(orderedAndBalanced("[(]"));
    }

    public static boolean orderedAndBalanced(String str) {
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher("");

        return false;
    }
}