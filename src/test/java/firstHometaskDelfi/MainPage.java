package firstHometaskDelfi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

class MainPage {
    private BaseSteps baseSteps;
    final By NEWS_ITEM = By.xpath(".//a");

    MainPage(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    List<WebElement> newsItems() {
        return baseSteps.findListOfElements(NEWS_ITEM);
    }

}
