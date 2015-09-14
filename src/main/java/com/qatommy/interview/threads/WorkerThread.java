package com.qatommy.interview.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkerThread extends Thread {
    public static final Logger logger = LogManager.getLogger(WorkerThread.class.getSimpleName());

    private final String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        logger.info("Start. Command = " + command);
        processCommand();
        logger.info("End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error(e.getClass().getSimpleName());
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
