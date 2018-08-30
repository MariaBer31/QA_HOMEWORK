package homeClassWorkDresses.pages;

import org.openqa.selenium.By;

public class WomenPage {
    private DriverFunc driverFunc;

    private final By WEARING_FILTER = By.xpath("//ul[@class=\"tree dynamized\"]//a");
    private final String WEARING = "Dresses";

    WomenPage(DriverFunc driverFunc) {
        this.driverFunc = driverFunc;
    }

    public DressesPage choseFilter() {
        driverFunc.wait(WEARING_FILTER);
        driverFunc.chooseElement(driverFunc.findElements(WEARING_FILTER), WEARING);
        driverFunc.wait(WEARING_FILTER);
        driverFunc.LOGGER.info("Redirecting to page +" + WEARING + "...");
        return new DressesPage(driverFunc);
    }
}
