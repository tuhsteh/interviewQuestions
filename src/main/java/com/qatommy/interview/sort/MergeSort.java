package com.qatommy.interview.sort;

public class MergeSort extends Sorter {
    @Override
    public void sort(Comparable<Integer>[] listToSort) {
        Comparable<Integer>[] temp = new Integer[listToSort.length];
        mergeSort(listToSort, temp, 0, listToSort.length - 1);
    }

    @Override
    public String getName() {
        return "Merge sort";
    }

    private void mergeSort(Comparable<Integer>[] listToSort, Comparable<Integer>[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(listToSort, temp, left, center);
            mergeSort(listToSort, temp, center + 1, right);
            merge(listToSort, temp, left, center + 1, right);
        }
    }

    private void merge(Comparable<Integer>[] listToSort, Comparable<Integer>[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (listToSort[leftPos].compareTo((Integer) listToSort[rightPos]) <= 0)
                temp[tempPos++] = listToSort[leftPos++];
            else
                temp[tempPos++] = listToSort[rightPos++];
        }

        while (leftPos <= leftEnd) {
            temp[tempPos++] = listToSort[leftPos++];
        }

        while (rightPos <= rightEnd) {
            temp[tempPos++] = listToSort[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            listToSort[rightEnd] = temp[rightEnd];
        }
    }
}
