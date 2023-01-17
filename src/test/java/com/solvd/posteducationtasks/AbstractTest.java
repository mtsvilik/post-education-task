package com.solvd.posteducationtasks;

import com.solvd.posteducationtasks.service.CapabilityFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public abstract class AbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(AbstractTest.class);
    protected static final ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();

    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp(String browserName) {
        LOGGER.info("Browser name is " + browserName);
        remoteDriver.set(new RemoteWebDriver(capabilityFactory.getCapabilities(browserName)));
    }

    public WebDriver getDriver() {
        return remoteDriver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    public void failedScreenshot() {
        File scrFile = ((TakesScreenshot) remoteDriver.get()).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        String timeStamp = date.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(scrFile, new File("./screenshots/" + "_" + timeStamp + ".png"));
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
