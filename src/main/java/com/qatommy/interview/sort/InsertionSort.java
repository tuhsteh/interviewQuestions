package com.qatommy.interview.sort;

public class InsertionSort extends Sorter {
    @Override
    public void sort(Comparable[] listToSort) {
        for (int p = 1; p < listToSort.length; p++) {
            Comparable tmp = listToSort[p];
            int j = p;

            for (; j > 0 && tmp.compareTo(listToSort[j - 1]) < 0; j--)
                listToSort[j] = listToSort[j - 1];
            listToSort[j] = tmp;
        }
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }
}
