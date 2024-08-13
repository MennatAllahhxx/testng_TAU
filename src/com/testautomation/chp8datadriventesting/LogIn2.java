package com.testautomation.chp8datadriventesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogIn2 {
    WebDriver driver;

    @Test(dataProvider = "login-provider")
    public void login(String username, String password, boolean success) {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        System.out.println("Login credentials:\n" +
                "  username: " + username + '\n' +
                "  password: " + password + '\n' +
                "  successful login: " + success + '\n');

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";

        assertEquals(expectedURL, actualURL, "Sign in was not successful");

        driver.quit();
    }

    @DataProvider(name = "login-provider")
    public Object [] [] logInData() {
        Object [] [] data = new Object[3][3];

        data[0][0] = "standard_user"; data[0][1] = "secret_sauce"; data[0][2] = true;
        data[1][0] = "problem_user";  data[1][1] = "DoeDoe34";     data[1][2] = false;
        data[2][0] = "visual_user";   data[2][1] = "secret_sauce"; data[2][2] = true;

        return data;
    }
}