package com.qatommy.interview.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ThreadRunner {
    public static final Logger logger = LogManager.getLogger(ThreadRunner.class.getSimpleName());

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.submit(worker);
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(1, SECONDS)) {
                logger.info("Finished all threads");
            } else {
                List<Runnable> runnables = executor.shutdownNow();
                logger.info("Stopping with " + runnables.size() + " things left to do.");
            }
        } catch (Throwable e) {
//            throw new Error("Timed Out");
            logger.info(e.getClass().getSimpleName());
        } finally {
            logger.info("\tAll done.");
        }

    }

}
