package com.qatommy.InterviewQuestions;

/**
 * There was a case I encountered where an assert gave me the
 * wrong answer.
 *
 * So I learned, an assert will take a boolean, but will not
 * change the world to derive a boolean.
 *
 * In this example, you can call a method to get a value,
 * but you cannot make an API call inside an assert for instance.
 */
public class JustAsserts {
	public static void main(String[] args) {
		assert (System.currentTimeMillis() > 1);
	}
}
