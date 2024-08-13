package com.testautomation.chp3annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class SwagLabs {
    WebDriver driver;

    @BeforeClass
    public void setUp()  {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        System.out.println("1. open chrome");
    }

    @Test(priority = 1)
    public void signIn() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        System.out.println("2. sign in");
    }

    @Test(priority = 2)
    public void addBackpack() {
        WebElement backpack = driver.findElement(By.id("item_4_title_link"));
        backpack.click();

        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart"));
        addToCartBtn.click();

        WebElement backToProductsBtn = driver.findElement(By.id("back-to-products"));
        backToProductsBtn.click();

        System.out.println("3. add backpack");
    }

    @Test(priority = 3)
    public void userSignOut() {
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();

        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        logoutBtn.click();

        System.out.println("4. sign out");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("5. close chrome");
        driver.quit();
    }
}