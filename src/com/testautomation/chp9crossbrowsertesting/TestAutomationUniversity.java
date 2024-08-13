package com.testautomation.chp9crossbrowsertesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAutomationUniversity {
    WebDriver driver;

    @Test
    @Parameters({"URL", "BrowserType"})
    public void verifyTAU(String url, String browserType) {
        if (browserType.equalsIgnoreCase("Edge Driver")) {
            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);

        System.out.println("\nOpen" + browserType);
        System.out.println("  " + driver.getTitle());
        System.out.println("Close " + browserType + "\n");

        driver.quit();
    }
}