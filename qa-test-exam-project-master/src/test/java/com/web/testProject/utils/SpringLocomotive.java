package com.web.testProject.utils;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Locomotive;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.fail;


public class SpringLocomotive extends Locomotive {

    private final String browserString;
    private final String hub;


    public SpringLocomotive(String browserString, String hub) {
        this.browserString = browserString;
        this.hub = hub;
        init();
    }

    public WebDriver getDriver() {
        if (super.driver == null) {
            throw new RuntimeException("WebDriver could not be started!");
        }
        if (((RemoteWebDriver) super.driver).getSessionId() == null) {
            init();
        }
        return super.driver;
    }


    private void init() {
        final Browser browser = Browser.valueOf(browserString);

        DesiredCapabilities capabilities;
        boolean isLocal = StringUtils.isEmpty(hub);

        switch (browser) {
            case CHROME:
                List<String> chromeOptionArgs = Arrays.asList("--start-maximized", "--disable-extensions", "--disable-infobars", "--ignore-certificate-errors");
                ChromeOptions options = new ChromeOptions();
                options.addArguments(chromeOptionArgs);
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability("platform", "WIN8"); //LINUX or WIN8
                if (isLocal) try {
                    super.driver = new ChromeDriver(capabilities);
                } catch (Exception x) {
                    logFatal("Also see https://github.com/conductor-framework/conductor/wiki/WebDriver-Executables");
                    System.exit(1);
                }
                break;
            default:
                System.err.println("Unknown browser: " + browser);
                return;
        }

        if (!isLocal)
            // they are using a hub.
            try {
                super.driver = new RemoteWebDriver(new URL(hub), capabilities); // just override the driver.
            } catch (Exception x) {
                logFatal("Couldn't connect to hub: " + hub);
                x.printStackTrace();
                return;
            }

        actions = new Actions(super.driver);
    }

    public List<WebElement> waitForElements(By by) {
        int attempts = 0;
        int size = driver.findElements(by).size();

        while (size == 0) {
            size = driver.findElements(by).size();
            if (attempts == MAX_ATTEMPTS) fail(String.format("Could not find %s after %d seconds",
                    by.toString(),
                    MAX_ATTEMPTS));
            attempts++;
            try {
                Thread.sleep(1000); // sleep for 1 second.
            } catch (Exception x) {
                fail("Failed due to an exception during Thread.sleep!");
                x.printStackTrace();
            }
        }
        return driver.findElements(by);
    }

    public void setMaxAttempts(int maxAttempts) {
        MAX_ATTEMPTS = maxAttempts;
    }

    public void setMaxTimeout(int maxTimeout) {
        MAX_TIMEOUT = maxTimeout;
    }

    public int getMaxTimeOut() {
        return MAX_TIMEOUT;
    }

}
