package home_classWork_dresses.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.List;

public class DriverFunc {
    private WebDriver driver;
    public final Logger LOGGER = LogManager.getLogger(DriverFunc.class);

    public DriverFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void openWebPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        LOGGER.info("Opening web-page " + url);
        driver.get(url);
    }

    void chooseElement(List<WebElement> webElements, String title) {
        LOGGER.info("Searching in list element with name " + title);
        for (WebElement webElement : webElements) {
            if (webElement.getText().contains(title)) {
                LOGGER.info("Element with text " + webElement.getText() + " is found");
                webElement.click();
                break;
            }
        }
    }

    public void closeWebPage() {
        driver.quit();
    }

    List<WebElement> findElements(By locator) {
        wait(locator);
        LOGGER.info("Searching for list of elements with locator " + locator);
        wait(locator);
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    WebElement findOneElement(By locator) {
        wait(locator);
        LOGGER.info("Element is found:" + locator);
        return driver.findElement(locator);
    }

    void wait(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    void waitForElement(By locator, Integer numberOfElementsIsLessThan) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeLessThan(locator, numberOfElementsIsLessThan));
    }

    void waitConditionTextToBe(By locator, String string) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(locator, string));
    }

    boolean isElementFound(By locator) {
        return findElements(locator).isEmpty();
    }

    public BigDecimal stringPriceToBigDecimal(String price) {
        String stringWithoutDollars = price.substring(1);
        return new BigDecimal(stringWithoutDollars);
    }
}
