package com.qatommy.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Does a for-each type of loop on an array list go
 * in the same order of the elements in the list as
 * you would find from a numeric-indexing based
 * processing of the list?
 */
public class ArrayListOrder {
	final static Random r = new Random(System.currentTimeMillis());

	public static void main(String[] args) {
		final int numberOfElements = 10;
		List<String> sampleList = new ArrayList<String>();
		for (int i = 0; i < numberOfElements; i++) {
			int temp = r.nextInt(numberOfElements * numberOfElements);
			sampleList.add(Integer.toString(temp));
		}

		int i = 0;
		for (String s : sampleList) {
			System.out.println(String.format("%d, %s\t%s", i, s, sampleList.get(i)));
			assert (s.equals(sampleList.get(i)));
			i = i + 1;
		}
	}
}
