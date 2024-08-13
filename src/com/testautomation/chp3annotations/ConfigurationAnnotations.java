package com.testautomation.chp3annotations;

import org.testng.annotations.*;

public class ConfigurationAnnotations {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("chrome - set up system property");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("open chrome");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("open test application");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("sign in");
    }

    @Test
    public void searchCustomer() {
        System.out.println("search for customer");
    }

    @Test
    public void searchProduct() {
        System.out.println("search for product");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("sign out");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("close test application");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("close chrome");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("chrome - clean up all cookies");
    }
}