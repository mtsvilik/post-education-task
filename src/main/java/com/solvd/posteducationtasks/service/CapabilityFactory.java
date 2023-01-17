package com.solvd.posteducationtasks.service;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class CapabilityFactory {

    private Capabilities capabilities;

    public Capabilities getCapabilities(String browser) {
        switch (browser) {
            case "chrome":
                capabilities = new ChromeOptions();
                break;
            case "firefox":
                capabilities = new FirefoxOptions();
                break;
            case "safari":
                capabilities = new SafariOptions();
                break;
            default:
                break;
        }
        return capabilities;
    }
}
