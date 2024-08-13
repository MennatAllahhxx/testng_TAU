package com.testautomation.chp7dependencytesting;

import org.testng.annotations.Test;

public class Amazon_FakeSite {
    @Test(groups = "smoke")
    public void test1_logIn() {
        System.out.println("1. log in / group = smoke \n");
    }

    @Test(groups = {"smoke", "regression"})
    public void test2_searchProducts() {
        System.out.println("2. search product / group = smoke, regression \n");
    }

    @Test(groups = {"regression", "integration", "defect.fix"})
    public void test3_placeOrder() {
        System.out.println("3. place order / group = regression, integration, defect.fix \n");
    }

    @Test(groups = {"system", "defect.backlog"})
    public void test4_sendConfirmation() {
        System.out.println("4. send confirmation / group = system, defect.backlog \n");
    }

    @Test(groups = {"regression", "defect.progress"})
    public void test5_shipOrder() {
        System.out.println("5. ship order / group = regression, defect.progress \n");
    }

    @Test
    public void test6_logOut() {
        System.out.println("6. log out / group = none \n");
    }
}