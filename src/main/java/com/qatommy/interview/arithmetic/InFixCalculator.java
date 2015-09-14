package com.qatommy.interview.arithmetic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InFixCalculator {
    public static final Logger logger = LogManager.getLogger(InFixCalculator.class.getSimpleName());

    private static final boolean DEBUG = false;

    public static void compute_expression(String expr) {
        int result = evaluate(expr);
        System.out.println(result);
    }

    public static int evaluate(String s) {
        int[] operands = new int[s.length()];
        int operandPtr = -1;
        char[] operators = new char[s.length()];
        int operatorPtr = -1;
        String operand = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            debug(c);
            if (c != '(' && c != ')' && c != '+' && c != '-') {
                operand += c;
            } else if (c == '+' || c == '-') {
                if (!operand.equals("")) {
                    debug(operand);
                    operands[++operandPtr] = Integer.valueOf(operand);
                    intArray(operands);
                    operand = "";
                }
                operators[++operatorPtr] = c;
                printArray(operators);
            } else if (c == ')') {
                if (!operand.equals("")) {
                    operands[++operandPtr] = Integer.valueOf(operand);
                    operand = "";
                }
                if (operatorPtr >= 0) {
                    intArray(operands);
                    int op2 = operands[operandPtr];
                    operands[operandPtr--] = 0;
                    debug("pop " + op2);
                    int op1 = operands[operandPtr];
                    operands[operandPtr--] = 0;
                    debug("pop " + op1);
                    char operator = operators[operatorPtr];
                    operators[operatorPtr--] = ' ';
                    debug("oper " + operator);
                    int subResult = performOp(op1, op2, operator);
                    operands[++operandPtr] = subResult;
                    intArray(operands);
                }
            } else if (c == '(') {
                continue;
            }
            if (i == s.length() - 1) {
                if (!operand.equals("")) {
                    operands[++operandPtr] = Integer.valueOf(operand);
                    operand = "";
                }
                for (int j = 0, k = 0; j <= operandPtr && k <= operatorPtr; ) {
                    //now, to finish up, evaluate left to right.
                    intArray(operands);
                    int op1 = operands[j];
                    operands[j++] = 0;
                    debug("pop" + op1);
                    int op2 = operands[j];
                    operands[j++] = 0;
                    debug("pop" + op2);
                    char operator = operators[k];
                    operators[k++] = ' ';
                    debug("oper" + operator);
                    int subResult = performOp(op1, op2, operator);
                    operands[--j] = subResult;
                    intArray(operands);
                }
            }
        }
        for(int r: operands) {
            if(r != 0) return r;
        }
        return 0;   //this works in case it actually IS zero.
    }

    private static int performOp(int op1, int op2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
        }
        return result;
    }

    private static void printArray(char[] c) {
        for (char ch : c) {
            debug(" " + ch);
        }
        debug("");
    }

    private static void intArray(int[] c) {
        for (int i : c) {
            debug(i + " ");
        }
        debug("");
    }

    private static void debug(char c) {
        if (DEBUG) System.out.println(c);
    }

    private static void debug(String s) {
        if (DEBUG) System.out.println(s);
    }

    private static void debug(int i) {
        if (DEBUG) System.out.println(i);
    }

}
