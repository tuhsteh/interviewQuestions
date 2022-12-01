package com.qatommy.interview.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BogoSort extends Sorter {
    @Override
    public void sort(Comparable<Integer>[] listToSort) {
        if (listToSort.length > 10) {
            System.out.println("You'd better not sort anything this big with a bogo sort.  Who knows when it will finish!?");
            System.out.println("We'll assume you meant to do a HeapSort() instead.");
            Sorter s = new HeapSort();
            s.sort(listToSort);
        } else {
            Comparable<Integer>[] temp = new Integer[listToSort.length];
            bogo(listToSort, temp);
        }
    }

    @Override
    public String getName() {
        return "Bogo Sort";
    }

    private void bogo(Comparable<Integer>[] listToSort, Comparable<Integer>[] temp) {
        temp = listToSort.clone();
        List<Comparable<Integer>> list = Arrays.asList(temp);
        while (!isSorted(list)) {
            Collections.shuffle(list);
        }

        int rightEnd = listToSort.length - 1;
        for (int i = 0; i < listToSort.length; i++, rightEnd--) {
            listToSort[rightEnd] = temp[rightEnd];
        }
    }


}
