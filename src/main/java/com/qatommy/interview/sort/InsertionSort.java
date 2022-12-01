package com.qatommy.interview.sort;

public class InsertionSort extends Sorter {
    @Override
    public void sort(Comparable<Integer>[] listToSort) {
        if (listToSort.length > 100_000) {
            System.out.println("You'd better not sort anything this big with an Insertion sort.  Who knows when it will finish!?");
            System.out.println("We'll assume you meant to do a HeapSort() instead.");
            Sorter s = new HeapSort();
            s.sort(listToSort);
        } else {
            Comparable<Integer>[] temp = new Integer[listToSort.length];
            insert(listToSort, temp);
        }        
    }
    
    private void insert(Comparable<Integer>[] listToSort, Comparable<Integer>[] temp) {
        temp = listToSort.clone();
        for (int p = 1; p < listToSort.length; p++) {
            Comparable<Integer> tmp = listToSort[p];
            int j = p;

            for (; j > 0 && tmp.compareTo((Integer) temp[j - 1]) < 0; j--)
                temp[j] = temp[j - 1];
            temp[j] = tmp;
        }

        int rightEnd = listToSort.length - 1;
        for (int i = 0; i < listToSort.length; i++, rightEnd--) {
            listToSort[rightEnd] = temp[rightEnd];
        }
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }
}
