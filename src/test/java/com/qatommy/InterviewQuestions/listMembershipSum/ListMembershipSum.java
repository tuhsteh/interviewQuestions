package com.qatommy.InterviewQuestions.listMembershipSum;

import com.google.common.collect.ImmutableSortedMap;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * From Joe Rowley in Slack
 * @kgb has a good one that we like to use: Given an array of ints,
 * find the sum of the most common value -- you can assume there will
 * be no ties (to simplify). So, for example, given [1, 12, 1, 5, 1] return 3
 */
public class ListMembershipSum {

	@Test
	public void testGetMembershipSum() {
		List<Integer> testArray1 = new ArrayList<Integer>() {{
			add(2);
			add(12);
			add(2);
			add(5);
			add(2);
		}};
		assertEquals(Integer.valueOf(6), getListMembershipSum(testArray1));

		List<Integer> testArray2 = new ArrayList<Integer>() {{
			add(1);
			add(12);
			add(1);
			add(5);
			add(1);
		}};
		assertEquals(Integer.valueOf(3), getListMembershipSum(testArray2));
	}

	public Integer getListMembershipSum(List<Integer> list) {
		Map<Integer, Integer> membershipCount = new TreeMap<>();
		for (Integer i : list) {
			Integer currentCount = (null == membershipCount.get(i)) ? 0 : membershipCount.get(i);
			membershipCount.put(i, currentCount + 1);
		}

		ValueComparator vc = new ValueComparator(membershipCount);
		ImmutableSortedMap<Integer, Integer> sortedMap = ImmutableSortedMap.copyOf(membershipCount, vc);

		Map.Entry<Integer, Integer> first = sortedMap.firstEntry();
		return first.getValue() * first.getKey();
	}

	class ValueComparator implements Comparator<Integer> {
		private final Map<Integer, Integer> base;
		public ValueComparator(Map<Integer, Integer> base) {
			this.base = base;
		}

		public int compare(Integer a, Integer b) {
			return (base.get(a) >= base.get(b)) ? -1 : 1;
		}
	}
}
