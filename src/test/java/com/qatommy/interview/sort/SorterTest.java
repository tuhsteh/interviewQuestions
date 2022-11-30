package com.qatommy.interview.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class SorterTest {

    public static final int ELEMENTS_TO_SORT = (int) Math.pow(10, 6);

    @Test
    public void testSort() throws Exception {
        System.out.println("Shuffling a list...");
        Integer[] shuffledInts = getListToSort(ELEMENTS_TO_SORT);
        System.out.println("Got a list of numbers to sort.");
        for (Sorter s : sorters) {
            System.out.println("--------------------------------------------------\n\tStarting " + s.getName());
            Integer[] a = shuffledInts.clone();
            s.printArray(a);
            long start = System.currentTimeMillis();
            s.sort(a);
            long end = System.currentTimeMillis();
            s.printArray(a);
            System.out.println(String.format("\t%s took %,d milliseconds to run.\n--------------------------------------------------\n\n\n", s.getName(), (end - start)));
            assertTrue("Failed asserting the list came back sorted.", s.isSorted(a));
        }
    }

    private Integer[] getListToSort(int size) {
        long start = System.currentTimeMillis();
        Integer[] list = new Integer[size];
        for (Integer i = 1; i <= size; i++) {
            list[i - 1] = i;
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Making a list of %,d elements took %,d milliseconds.", size, (end - start)));
        start = System.currentTimeMillis();
        List<Integer> returnValue = Arrays.asList(list);
        Collections.shuffle(returnValue);
        end = System.currentTimeMillis();
        System.out.println(String.format("Shuffling that list took %,d milliseconds.", (end - start)));
        return returnValue.toArray(new Integer[returnValue.size()]);
    }

    List<? extends Sorter> sorters = Arrays.asList(
            new MergeSort(),
            new HeapSort(),
//            new BogoSort(),
//            new InsertionSort(),
            new QuickSort()
    );

}
