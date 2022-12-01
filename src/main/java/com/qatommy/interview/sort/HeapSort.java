package com.qatommy.interview.sort;

public class HeapSort extends Sorter {
    @Override
    public void sort(Comparable<Integer>[] listToSort) {
        for (int i = listToSort.length / 2; i >= 0; i--)  /* buildHeap */
            percDown(listToSort, i, listToSort.length);
        for (int i = listToSort.length - 1; i > 0; i--) {
            swapReferences(listToSort, 0, i);             /* deleteMax */
            percDown(listToSort, 0, i);
        }
    }

    @Override
    public String getName() {
        return "Heap sort";
    }

    /**
     * Internal method for heapsort.
     *
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Internal method for heapsort that is used in
     * deleteMax and buildHeap.
     *
     * @param a an array of Comparable items.
     * @index i the position from which to percolate down.
     * @int n the logical size of the binary heap.
     */
    private static void percDown(Comparable<Integer>[] a, int i, int n) {
        int child;
        Comparable<Integer> tmp;

        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo((Integer) a[child + 1]) < 0)
                child++;
            if (tmp.compareTo((Integer) a[child]) < 0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
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

}
