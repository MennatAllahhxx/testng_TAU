package com.testautomation.chp3annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class BM_AM_OrangeHRM {
    WebDriver driver;

    @BeforeClass
    public void setUp()  {

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("1. open chrome");
    }

    @Test
    public void signIn() {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));



        WebElement loginButton = driver.findElement(By.className("oxd-button"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();

        System.out.println("2. sign in");
    }

    @Test
    void userSearch() {
        WebElement adminMenu = driver.findElement(By.linkText("Admin"));
        adminMenu.click();

        WebElement userSearch = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
        userSearch.sendKeys("Admin");

        WebElement userSearchBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        userSearchBtn.click();

        System.out.println("3. search for user");
    }

    @Test
    public void userSignOut() {
        WebElement userMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span"));
        userMenu.click();

        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
        logoutBtn.click();

        System.out.println("4. sign out");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("5. close chrome");
        driver.quit();
    }
}