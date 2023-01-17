package com.solvd.posteducationtasks.listener;

import com.solvd.posteducationtasks.AbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener extends AbstractTest implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(AbstractTest.class);

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test FAILED");
        failedScreenshot();
    }
}
