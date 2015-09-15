package com.qatommy.InterviewQuestions.collectionPerformance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListPerformanceTests extends CollectionPerformanceTest {
    public final Logger LOGGER = LogManager.getLogger(getClass());

    List<String> listOfRandomStrings = new ArrayList<>();

    @Before
    public void setUp() {
        LOGGER.trace("Setup");
        for (int i = 0; i < MAX_ITEMS; i++) {
            listOfRandomStrings.add(makeARandomString(STRING_LENGTH));
        }
        LOGGER.trace("Setup finished");
    }

    @Test
    public void testListContains() {
        final int randomItem = R.nextInt(MAX_ITEMS);
        LOGGER.trace(String.format("Looking for item number %,d", randomItem));
        String found = listOfRandomStrings.get(randomItem);
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < LOOKUP_COUNT; i++) {
            boolean contains = listOfRandomStrings.contains(found);
        }
        end = System.currentTimeMillis();
        LOGGER.info(String.format("CONTAINS -- Finding item number %,d - %,d times took %,d ms.", randomItem, LOOKUP_COUNT, (end - start) ));
    }

    @Test
    public void testListAdd() {
        List<String> testList = new ArrayList<>();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            testList.add(makeARandomString(STRING_LENGTH));
        }
        end = System.currentTimeMillis();
        LOGGER.info(String.format("ADD -- Generating and Filling the list with %,d random items took %,d ms.", MAX_ITEMS, (end - start)));
    }

    @Test
    @Ignore("Heap Space error.  just don't do it.")
    public void testListAddAll() {
        List<String> testList = new ArrayList<>();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            testList.addAll(listOfRandomStrings);
        }
        end = System.currentTimeMillis();
        LOGGER.info(String.format("ADD_ALL -- Adding a list of %,d random items to the list at once took %,d ms.", MAX_ITEMS, (end - start)));
    }

    @Test
    public void testListRemove() {
        LOGGER.trace("Inner Setup");
        List<String> testList = new ArrayList<>();
        testList.addAll(listOfRandomStrings);
        LOGGER.trace("Inner Setup Finished");
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            String s = testList.get(R.nextInt(testList.size()));
            testList.remove(s);
        }
        end = System.currentTimeMillis();
        LOGGER.info(String.format("REMOVE -- Removing each item from the list of %,d random items took %,d ms.", MAX_ITEMS, (end - start)));
    }

    @Test
    public void testListRemoveAll() {
        LOGGER.trace("Inner Setup");
        List<String> testList = new ArrayList<>();
        testList.addAll(listOfRandomStrings);
        LOGGER.trace("Inner Setup Finished");
        long start, end;
        start = System.currentTimeMillis();
        testList.removeAll(listOfRandomStrings);
        end = System.currentTimeMillis();
        LOGGER.info(String.format("REMOVE_ALL -- Removing every item from the list of %,d random items at once took %,d ms.", MAX_ITEMS, (end - start)));
    }

}
