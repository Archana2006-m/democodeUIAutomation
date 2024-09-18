package com.seauto.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class productsPage extends BasePage {
    
		// TODO Auto-generated constructor stub
	
	By drpSort = By.xpath("//select[@data-test='product_sort_container']");
    By lstProduct = By.xpath("//div[contains(@class,'inventory_list')]/div");
    By lstProduct_title = By.xpath(".//a[contains(@id,'title_link')]");
    By lstProduct_add = By.xpath(".//button[contains(@class,'btn_inventory')][contains(@id,'add-to-cart')]");
    By lstProduct_remove = By.xpath(".//button[contains(@class,'btn_inventory')][contains(@id,'remove')]");

    public productsPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getProduct(String title) {
        return driver.findElements(lstProduct)
                .stream()
                .filter(element -> element.findElement(lstProduct_title).getText().equals(title))
                .findFirst()
                .orElseThrow(null);
    }

    public productsPage sort(String orderBy) {
        WebElement dropdown = driver.findElement(drpSort);
        Select select = new Select(dropdown);
        select.selectByVisibleText(orderBy);
        return this;
    }

    public productsPage add(String title) {
        getProduct(title)
                .findElement(lstProduct_add)
                .click();
        return this;
    }

    public productsPage remove(String title) {
        getProduct(title)
                .findElement(lstProduct_remove)
                .click();
        return this;
    }
}
