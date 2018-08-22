package secondHometaskDelfi.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasicFunctions {
    private WebDriver driver;
    public final Logger LOGGER = LogManager.getLogger(BasicFunctions.class);

    public BasicFunctions() {
        //System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }

    List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public void waitForElement(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement getElement(By locator) {
        waitForElement(locator);
        return driver.findElement(locator);
    }

    public List<String> stringList(List<WebElement> webElements) {
        List<String> strings = new ArrayList<String>();
        for (WebElement webElement : webElements) {
            strings.add(webElement.getText());
        }
        return strings;
    }

    public Integer stringToInt(String string) {
        return Integer.parseInt(string.replaceAll("[^0-9]", ""));
    }
}
