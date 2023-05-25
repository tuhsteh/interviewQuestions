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

        List<Character> stack = new ArrayList<Character>();
        System.out.println("Str:  " + str);
        for (int i = 0; i < str.length(); i++) {
            System.out.println("Stack: " + stack);
            if (str.charAt(i) == '(') {// opening a paren pair.
                System.out.println("Stack: " + stack);
                stack.add('(');
            }
            if (str.charAt(i) == '[') {// opening a brace pair.
                System.out.println("Stack: " + stack);
                stack.add('[');
            }
            if (str.charAt(i) == ']' && i == 0) {
                System.out.println("Stack: " + stack);
                System.out.println("Missing opening square brace");
                return false;
            }
            if (str.charAt(i) == ')' && i == 0) {
                System.out.println("Missing opening paren");
                return false;
            }
            if (str.charAt(i) == ']') {
                System.out.println("Stack: " + stack);
                if (stack.get(stack.size() - 1) != '[') {
                    System.out.println("Unbalanced square braces");
                    return false;
                } else {
                    stack.remove(stack.size() - 1);
                }
            }
            if (str.charAt(i) == ')') {
                System.out.println("Stack: " + stack);
                if (stack.get(stack.size() - 1) != '(') {
                    System.out.println("Unbalanced parentheses");
                    return false;
                } else {
                    stack.remove(stack.size() - 1);
                }
            }
        }
        if (stack.size() != 0) {
            System.out.println("Not balanced.");
            return false;
        }

        return true;
    }
}