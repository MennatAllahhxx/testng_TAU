package com.testautomation.chp8datadriventesting;

import com.testautomation.chp7dependencytesting.SignInDP;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class OrangeHRM {
    WebDriver driver;

    @Test(dataProviderClass = SignInDP.class, dataProvider = "signin-provider")
    public void SignIn(String username, String password, boolean success) {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.className("oxd-button"));
        loginButton.click();

        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualURL = driver.getCurrentUrl();

        System.out.println("Login credentials:\n" +
                "  username: " + username + '\n' +
                "  password: " + password + '\n' +
                "  successful login: " + success + '\n');

        driver.quit();

        assertEquals(expectedURL, actualURL, "log in was not successful");
    }
}