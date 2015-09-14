package com.qatommy.interview.arithmetic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class LoopSpeedTest {
    public static final Logger logger = LogManager.getLogger(LoopSpeed.class.getSimpleName());

    public static final int THOUSAND            = 1_000;
    public static final int TEN_THOUSAND        = 10_000;
    public static final int HUNDRED_THOUSAND    = 100_000;
    public static final int MILLION             = 1_000_000;


    @Test
    public void testLoopThousand() {
        final int count = THOUSAND;

        long start, end;
        start = System.nanoTime();
        LoopSpeed.loop(count);
        end = System.nanoTime();
        long duration = end - start;
        log(count, duration);
    }

    @Test
    public void testLoopTenThousand() {
        final int count = TEN_THOUSAND;

        long start, end;
        start = System.nanoTime();
        LoopSpeed.loop(count);
        end = System.nanoTime();
        long duration = end - start;
        log(count, duration);
    }

    @Test
    public void testLoopHundredThousand() {
        final int count = HUNDRED_THOUSAND;

        long start, end;
        start = System.nanoTime();
        LoopSpeed.loop(count);
        end = System.nanoTime();
        long duration = end - start;
        log(count, duration);
    }

    @Test
    public void testLoopMillion() {
        final int count = MILLION;

        long start, end;
        start = System.nanoTime();
        LoopSpeed.loop(count);
        end = System.nanoTime();
        long duration = end - start;
        log(count, duration);
    }

    private void log(int items, long duration) {
        logger.info(String.format("Took %,d nanoseconds to loop %,d items", duration, items));
    }
}