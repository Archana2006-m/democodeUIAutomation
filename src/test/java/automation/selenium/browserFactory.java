package automation.selenium;


import automation.enums.browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserFactory {

    public static WebDriver launch(browsers browser) {
        if (browser.equals(browsers.CHROME)) {
            return new ChromeDriver();
        } else if (browser.equals(browsers.FIREFOX)) {
            return new FirefoxDriver();
        } else if (browser.equals(browsers.EDGE)) {
            return new EdgeDriver();
        }

        // default
        return new ChromeDriver();
    }
}