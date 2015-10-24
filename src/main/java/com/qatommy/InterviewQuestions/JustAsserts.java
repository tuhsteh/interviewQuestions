package com.qatommy.InterviewQuestions;

/**
 * I once saw a plain old java "assert" operator call fail to behave the way I expected.
 * I later learned the reason is that the assert operator will only do a comparison to true,
 * not modify the world using any function inside the assert call.  
 * In short, assert operations have no side-effects.
 */ 
public class JustAsserts {
	public static void main(String[] args) {
		assert (System.currentTimeMillis() > 1);
	}
}
