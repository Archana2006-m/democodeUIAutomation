package com.seauto.tests;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.seauto.config.environmentVariables;
import automation.enums.browsers;
import automation.selenium.browserFactory;

public abstract class BaseTest {

    // TODO: Externalise config data
    protected WebDriver driver;
    private browsers browser = browsers.CHROME;
    private String url = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setup() {
        driver =browserFactory.launch(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(environmentVariables.WAIT_IMPLICIT));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
