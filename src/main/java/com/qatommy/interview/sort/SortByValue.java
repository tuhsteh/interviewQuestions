package com.qatommy.interview.sort;

import java.util.*;

public class SortByValue {

    // function to sort hashmap by values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new NestedComparator());

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    // Driver Code
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        
        // print the hashmap sorted by keys.
        System.out.println("Sorted by Key Name:");
        TreeMap<String, Integer> sorted = new TreeMap<>();
        sorted.putAll(hm);
        for (Map.Entry<String, Integer> en : sorted.entrySet()) {
            System.out.println("  Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }
        
        // print the sorted hashmap
        System.out.println("Sorted by Value:");
        Map<String, Integer> hm1 = sortByValue(hm);
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println("  Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }
    }

    // private static Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
    //     public int compare(Map.Entry<String, Integer> o1,
    //             Map.Entry<String, Integer> o2) {
    //         return (o1.getValue()).compareTo(o2.getValue());
    //     }
    // };
}

class NestedComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1,
            Map.Entry<String, Integer> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
    }

}