package com.qatommy.interview.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkerThread extends Thread {
    public static final Logger logger = LogManager.getLogger(WorkerThread.class.getSimpleName());
    private static final int THREAD_LIFE = 2000; //milliseconds

    private final String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    /**
     * Includes the thread name in the log statement.
     * @param message   The message to log.
     */
    private void log (String message) {
        logger.info(String.format("[%s] %s", toString(), message));
    }

    @Override
    public void run() {
        log("Start. Command = " + command);
        processCommand();
        log("End.");
    }

    /**
     * This is simply something to do that takes time.
     */
    private void processCommand() {
        try {
            Thread.sleep(THREAD_LIFE);
        } catch (InterruptedException e) {
            logger.error(e.getClass().getSimpleName());
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
