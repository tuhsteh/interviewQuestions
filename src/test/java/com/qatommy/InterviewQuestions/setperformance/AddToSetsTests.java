package com.qatommy.InterviewQuestions.setperformance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AddToSetsTests {
	public static final long TEST_VALUE = 1L;
	private static final int MAX_ITERATIONS = (int) Math.pow(10, 6);
	private static Logger logger = LogManager.getLogger(AddToSetsTests.class.getSimpleName());

	@Test
	public void testAddExistingItemsToHashSet() {
		final Set<Long> longSet = new HashSet<Long>();
		longSet.add(TEST_VALUE);

		// now add the same test value to the set a bunch of times.
		long start = 0l;
		long end = 0l;
		start = System.currentTimeMillis();
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			longSet.add(TEST_VALUE);
		}
		end = System.currentTimeMillis();
		logger.warn(String.format("Took %d milliseconds to add %,d existing items to a hash set.", (end - start), MAX_ITERATIONS));
	}

	@Test
	public void testAddNewItemsToHashSet() {
		final Set<Long> longSet = new HashSet<Long>();
		longSet.add(TEST_VALUE);

		// now add a bunch of unique test values to the set.
		long start = 0l;
		long end = 0l;
		start = System.currentTimeMillis();
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			longSet.add(TEST_VALUE + i);
		}
		end = System.currentTimeMillis();

		logger.warn(String.format("Took %d milliseconds to add %,d new items to a hash set.", (end - start), MAX_ITERATIONS));
	}
}
