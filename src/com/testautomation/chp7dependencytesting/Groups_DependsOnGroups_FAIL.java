package com.testautomation.chp7dependencytesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Groups_DependsOnGroups_FAIL {
    WebDriver driver;

    @Test(groups = "initialize")
    public void test1_setUp()  {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        System.out.println("1. open chrome");
    }

    @Test(dependsOnGroups = "initialize", groups = "env_application")
    public void test2_openOrangeHRM() {
        driver.get("https://opensource-demo.orangehrmlive123.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("2. open orange HRM");
    }

    @Test(dependsOnGroups = "env_application")
    public void test3_signIn() {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

        WebElement loginButton = driver.findElement(By.className("oxd-button"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();

        System.out.println("3. sign in");
    }

    @Test(dependsOnGroups = "env_application")
    public void test4_adminSearch() {
        WebElement adminMenu = driver.findElement(By.linkText("Admin"));
        adminMenu.click();

        WebElement adminSearch = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
        adminSearch.sendKeys("Admin");

        WebElement adminSearchBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        adminSearchBtn.click();

        System.out.println("4. search for admin");
    }

    @Test(dependsOnGroups = "env_application")
    public void test5_userSearch() {
        WebElement pimMenu = driver.findElement(By.linkText("PIM"));
        pimMenu.click();

        WebElement userSearch = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
        userSearch.sendKeys("John Doe");

        WebElement userSearchBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        userSearchBtn.click();

        System.out.println("5. search for user");
    }

    @Test(dependsOnGroups = "env_application")
    public void test6_userSignOut() {
        WebElement userMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span"));
        userMenu.click();

        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
        logoutBtn.click();

        System.out.println("6. sign out");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("5. close chrome");
        driver.quit();
    }
}