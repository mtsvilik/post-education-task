package com.solvd.posteducationtasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    protected static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        threadLocalDriver.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        threadLocalDriver.get().close();
    }

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }
}
