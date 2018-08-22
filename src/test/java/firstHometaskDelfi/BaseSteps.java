package firstHometaskDelfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseSteps {
    private WebDriver webDriver;
    private final Logger LOGGER = LogManager.getLogger(BaseSteps.class);

    BaseSteps() {
        LOGGER.info("Running chrome driver");
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    void openPage(String pageUrl) {
        LOGGER.info("Opening page" + pageUrl);
        webDriver.get(pageUrl);
    }

    public void scrollPage(Integer pageHeight) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        LOGGER.info("Scrolling down page");
        for (int i = 0; i < pageHeight; i += 100) {
            js.executeScript("scrollBy(0,100)");
        }
    }

    List<WebElement> findListOfElements(By locator) {
        return webDriver.findElements(locator);
    }

    boolean isArticleFound(String articleName, By locator) {
        LOGGER.info("Selecting from articles article with name " + articleName);
        boolean isArticleFound = false;
        for (int i = 0; i < findListOfElements(locator).size(); i++) {
            if (findListOfElements(locator).get(i).getText().contains(articleName)) {
                isArticleFound = true;
                LOGGER.info("Element " + articleName + " is found");
                LOGGER.info("Full article name is: " + findListOfElements(locator).get(i).getText());
                break;
            }
        }
        return isArticleFound;
    }

    void closePage() {
        webDriver.quit();
    }
}

