package com.qatommy.interview.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Examining thread ordering, management, not giving threads enough time.
 * Who reports they finished first, the thread or the manager?
 */
public class ThreadRunner {
    public static final Logger logger = LogManager.getLogger(ThreadRunner.class.getSimpleName());
    private static final int N_THREADS = 10;
    private static final int MAX_THREADS = 100;
    private static final int TIMEOUT = 10;  //seconds

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

        for (int i = 0; i < MAX_THREADS; i++) {
            Runnable worker = new WorkerThread(Integer.toString(i));
            executor.submit(worker);
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(TIMEOUT, SECONDS)) {
                logger.info("Finished all threads");
            } else {
                List<Runnable> runnables = executor.shutdownNow();
                logger.info("Stopping with " + runnables.size() + " things left to do.");
            }
        } catch (Throwable e) {
            logger.info(e.getClass().getSimpleName());
        } finally {
            logger.info("\tAll done.");
        }

    }

}
