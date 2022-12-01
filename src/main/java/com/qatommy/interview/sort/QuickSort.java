package com.qatommy.interview.sort;

public class QuickSort extends Sorter {

    @Override
    public void sort(Comparable<Integer>[] listToSort) {
        quicksort(listToSort, 0, listToSort.length - 1);
    }

    @Override
    public String getName() {
        return "Quick sort";
    }

    private static final int CUTOFF = 10;

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     *
     * @param a    an array of Comparable items.
     * @param low  the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     */
    private static void quicksort(Comparable<Integer>[] a, int low, int high) {
        if (low + CUTOFF > high) {
            insertionSort(a, low, high);
        } else {
            // Sort low, middle, high
            int middle = (low + high) / 2;
            if (a[middle].compareTo((Integer) a[low]) < 0)
                swapReferences(a, low, middle);
            if (a[high].compareTo((Integer) a[low]) < 0)
                swapReferences(a, low, high);
            if (a[high].compareTo((Integer) a[middle]) < 0)
                swapReferences(a, middle, high);

            // Place pivot at position high - 1
            swapReferences(a, middle, high - 1);
            Comparable<Integer> pivot = a[high - 1];

            // Begin partitioning
            int i, j;
            for (i = low, j = high - 1; ; ) {
                while (a[++i].compareTo((Integer) pivot) < 0)
                    ;
                while (pivot.compareTo((Integer) a[--j]) < 0)
                    ;
                if (i >= j)
                    break;
                swapReferences(a, i, j);
            }

            // Restore pivot
            swapReferences(a, i, high - 1);

            quicksort(a, low, i - 1);    // Sort small elements
            quicksort(a, i + 1, high);   // Sort large elements
        }
    }

    /**
     * Method to swap to elements in an array.
     *
     * @param a      an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static final void swapReferences(Object[] a, int index1, int index2) {
        Object tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }


    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     *
     * @param a     an array of Comparable items.
     * @param low   the left-most index of the subarray.
     * @param high  the number of items to sort.
     */
    private static void insertionSort(Comparable<Integer>[] a, int low, int high) {
        for (int p = low + 1; p <= high; p++) {
            Comparable<Integer> tmp = a[p];
            int j;

            for (j = p; j > low && tmp.compareTo((Integer) a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

}
