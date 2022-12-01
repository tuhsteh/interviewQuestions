package com.qatommy.InterviewQuestions.lifecycle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.assertTrue;

public class LifeCycleOrderingTests {
    private static Logger logger = LogManager.getLogger(LifeCycleOrderingTests.class.getSimpleName());
    private static String staticValue;
    private String testValue = "initial";

    public LifeCycleOrderingTests() {
        waitAQuarterSecond();
        logger.info("Class Construction");
    }

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            super.starting(description);
            waitAQuarterSecond();
            logger.info("Done calling super.starting.\n\n");
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
            waitAQuarterSecond();
            logger.info("Done calling super.finished.\n\n");
        }
    };

    @Rule
    public TestName testName = getTestName();

    private TestName getTestName() {
        waitAQuarterSecond();
        logger.info("Recording TestName, @Rule Method");
        TestName testName = new TestName();
        waitAQuarterSecond();
        logger.info("Done Recording TestName\n\n");
        return testName;
    }

    @Before
    public void recordTestName() {
        waitAQuarterSecond();
        logger.info("Recording TestName, @Before method");
        waitAQuarterSecond();
        ThreadContext.push(testName.getMethodName());
        logger.info("TestName:  " + testName);
        waitAQuarterSecond();
        logger.info("Done Recording TestName\n\n");
    }

    @BeforeClass
    public static void classSetup() {
        LifeCycleOrderingTests.staticValue = "staticValue";
        waitAQuarterSecond();
        logger.info("Recording static value @BeforeClass");
    }

    @Before
    public void setUp() {
        waitAQuarterSecond();
        logger.info("Establishing TestValue");
        testValue = "Value To Test";
        waitAQuarterSecond();
        logger.info("Done Establishing TestValue\n\n");
    }

    @Test
    public void testFirstPrintTestValue() {
        waitAQuarterSecond();
        logger.info("Running First Test Alphabetically");
        logger.info("TestValue:  " + testValue);
        assertTrue("Failed to find the established test-value.", testValue != null);
        waitAQuarterSecond();
        logger.info("Done with Test testFirstPrintTestValue\n\n");
    }

    @Test
    public void testSecondPrintTestValue() {
        waitAQuarterSecond();
        logger.info("Running Second Test Alphabetically");
        testValue = "second";
        waitAQuarterSecond();
        logger.info(testValue);
        assertTrue("Failed to find the established test-value.", testValue != null);
        waitAQuarterSecond();
        logger.info("Done with Test testSecondPrintTestValue\n\n");
    }

    @After
    public void tearDown() {
        waitAQuarterSecond();
        logger.info("Removing TestValue");
        testValue = null;
        logger.info("Done Removing TestValue\n\n");
    }

    @After
    public void zeroOutThreadContext() {
        waitAQuarterSecond();
        logger.info("Emptying ThreadContext");
        ThreadContext.pop();
        waitAQuarterSecond();
        logger.info("Done Emptying ThreadContext\n\n");
    }

    @AfterClass
    public static void recordFinal() {
        waitAQuarterSecond();
        logger.info("Recording End of TestName");
        waitAQuarterSecond();
        logger.info("StaticValue:  " + staticValue);
        waitAQuarterSecond();
        logger.info("Done Recording End of TestName\n\n");
    }

    private static void waitAQuarterSecond() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}