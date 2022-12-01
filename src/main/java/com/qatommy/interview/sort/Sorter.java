package com.qatommy.interview.sort;

import java.util.List;

public abstract class Sorter {
    public abstract void sort(Comparable<Integer>[] listToSort);

    public boolean isSorted(Comparable<Integer>[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo((Integer) a[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSorted(List<Comparable<Integer>> a) {
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).compareTo((Integer) a.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public void printArray(Comparable<Integer>[] a) {
        final int lineLength = 20;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
            if (i != 0 && 1 % lineLength == 0) System.out.println("");
            if (i > 20) {
                System.out.println("...");
                break;
            }
        }
        System.out.println("");
    }

    public abstract String getName();
}
