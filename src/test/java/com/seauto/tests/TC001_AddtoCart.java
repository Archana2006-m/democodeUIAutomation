package com.seauto.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.seauto.pages.*;

import userInfo.checkYourInfo;


public class TC001_AddtoCart extends BaseTest {

    // TODO: Data provider
    String dtUsername = "standard_user";
    String dtPassword = "secret_sauce";

    String prod1 = "Sauce Labs Onesie";
    String prod2 = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void TC001_AddToCart() {

        // TODO: Data provider
    	checkYourInfo dtYourInfo = new checkYourInfo();
        dtYourInfo.setFirstName("Elliot");
        dtYourInfo.setLastName("Michelle");
        dtYourInfo.setZip("4");

        new LoginPage(driver).login(dtUsername, dtPassword);
        new productsPage(driver)
                .add(prod1)
                .add(prod2);

        checkoutPage pgCheckout = new shoppingCartPage(driver)
                .open()
                .checkout()
                .setInformation(dtYourInfo)
                .finish();
        Assert.assertTrue(pgCheckout.isCheckoutComplete());
    }
}
