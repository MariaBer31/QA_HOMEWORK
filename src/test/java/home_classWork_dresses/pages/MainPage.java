package home_classWork_dresses.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class MainPage {
    private DriverFunc driverFunc;

    private final By WOMEN_TOPIC = By.xpath("//a[@title=\'Women\']");

    public MainPage(DriverFunc driverFunc) {
        this.driverFunc = driverFunc;
        Assert.assertFalse("There is no WOMEN topic", driverFunc.isElementFound(WOMEN_TOPIC));
    }

    public WomenPage openWomenPage() {
        driverFunc.LOGGER.info("Choosing topic WOMEN");
        driverFunc.wait(WOMEN_TOPIC);
        driverFunc.findOneElement(WOMEN_TOPIC).click();
        return new WomenPage(driverFunc);
    }
}
