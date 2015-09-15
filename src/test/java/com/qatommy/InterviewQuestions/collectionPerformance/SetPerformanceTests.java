package com.qatommy.InterviewQuestions.collectionPerformance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class SetPerformanceTests extends CollectionPerformanceTest {
    public final Logger LOGGER = LogManager.getLogger(getClass());

    Set<String> setOfRandomStrings = new HashSet<>();
    List<String> listOfRandomStrings = new ArrayList<>();

    @Before
    public void setUp() {
        LOGGER.trace("Setup");
        for (int i = 0; i < MAX_ITEMS; i++) {
            String s = makeARandomString(STRING_LENGTH);
            setOfRandomStrings.add(s);
            listOfRandomStrings.add(s);
        }
        LOGGER.trace("Setup finished");
    }

    @Test
    public void testSetContains() {
        final int randomItem = R.nextInt(MAX_ITEMS);
        LOGGER.trace(String.format("Looking for item number %,d", randomItem));
        String found = null;
        for (int i = 0; i < randomItem; i++) {
            found = setOfRandomStrings.iterator().next();
        }
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < LOOKUP_COUNT; i++) {
            boolean contains = setOfRandomStrings.contains(found);
        }
        end = System.nanoTime();
        LOGGER.info(String.format("CONTAINS -- Finding item number %,d - %,d times took %,d nanoseconds.", randomItem, LOOKUP_COUNT, (end - start) ));
    }

    @Test
    public void testSetAdd() {
        Set<String> testSet = new HashSet<>();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            testSet.add(makeARandomString(STRING_LENGTH));
        }
        end = System.currentTimeMillis();
        LOGGER.info(String.format("ADD -- Generating and Filling the set with %,d random items took %,d ms.", MAX_ITEMS, (end - start)));
    }

    @Test
    public void testSetAddDuplicates() {
        final String s = makeARandomString(STRING_LENGTH);
        Set<String> testSet = new HashSet<>();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            testSet.add(s);
        }
        end = System.currentTimeMillis();
        LOGGER.info(String.format("ADD -- Adding the same item to a set %,d times took %,d ms.", MAX_ITEMS, (end - start)));
    }

    @Test
    public void testSetAddAll() {
        Set<String> testSet = new HashSet<>();
        long start, end;
        start = System.currentTimeMillis();
        testSet.addAll(setOfRandomStrings);
        end = System.currentTimeMillis();
        LOGGER.info(String.format("ADD_ALL -- Adding a set of %,d random items to the set at once took %,d ms.", MAX_ITEMS, (end - start)));
    }

    @Test
    public void testSetRemove() {
        LOGGER.trace("Inner Setup");
        Set<String> testSet = new HashSet<>();
        List<String> testList = new ArrayList<>();
        testSet.addAll(setOfRandomStrings);
        testList.addAll(setOfRandomStrings);
        LOGGER.trace("Inner Setup Finished");
        long start, end;
        long ignoreStart, ignoreEnd;
        start = System.currentTimeMillis();
        while (testSet.size() > 0) {
            String s = testList.get(R.nextInt(testSet.size()));
            testSet.remove(s);
            ignoreStart = System.currentTimeMillis();
            testList.remove(s);
            ignoreEnd = System.currentTimeMillis();
            start += (ignoreEnd - ignoreStart);
        }
        end = System.currentTimeMillis();
        LOGGER.info(String.format("REMOVE -- Removing each item from the set of %,d random items took %,d ms.", MAX_ITEMS, (end - start)));
    }

    @Test
    public void testSetRemoveAll() {
        LOGGER.trace("Inner Setup");
        Set<String> testSet = new HashSet<>();
        testSet.addAll(setOfRandomStrings);
        LOGGER.trace("Inner Setup Finished");
        long start, end;
        start = System.currentTimeMillis();
        testSet.removeAll(setOfRandomStrings);
        end = System.currentTimeMillis();
        LOGGER.info(String.format("REMOVE_ALL -- Removing every item from the set of %,d random items at once took %,d ms.", MAX_ITEMS, (end - start)));
    }

}
