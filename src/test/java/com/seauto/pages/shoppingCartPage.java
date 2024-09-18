package com.seauto.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shoppingCartPage extends BasePage {

    By lstProduct = By.xpath("//div[contains(@class,'cart_list')]/div[contains(@class,'cart_item')]");
    By lstProduct_title = By.xpath(".//a[contains(@id,'title_link')]");
    By btnCart = By.id("shopping_cart_container");

    public shoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getProduct(String title) {
        return driver.findElements(lstProduct)
                .stream()
                .filter(element -> element.findElement(lstProduct_title).getText().equals(title))
                .findFirst()
                .orElseThrow(null);
    }

    public boolean isProductInCart(String title) {
        return getProduct(title).isDisplayed();
    }

    public shoppingCartPage open() {
        driver.findElement(btnCart).click();
        return this;
    }

    public checkoutPage checkout() {
        driver.findElement(By.id("checkout")).click();
        return new checkoutPage(driver);
    }
}