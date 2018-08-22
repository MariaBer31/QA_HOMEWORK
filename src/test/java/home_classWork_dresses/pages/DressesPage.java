package home_classWork_dresses.pages;

import org.openqa.selenium.By;

public class DressesPage {
    private DriverFunc driverFunc;
    private final By COLOR_FILTER = By.name("layered_id_attribute_group_13");
    private final By DRESS_ITEMS = By.xpath(".//ul[@class=\"product_list grid row\"]/li");
    public final By ORANGE_1 = By.xpath(".//a[@id=\"color_13\"]");
    public final By ORANGE_2 = By.xpath(".//a[@id=\"color_21\"]");

    DressesPage(DriverFunc driverFunc) {
        this.driverFunc = driverFunc;
    }

    public void choseColor() {
        driverFunc.LOGGER.info("I like orange");
        driverFunc.findOneElement(COLOR_FILTER).click();
    }

    private Integer howMuchItemsFound() {
        driverFunc.wait(DRESS_ITEMS);
        return driverFunc.findElements(DRESS_ITEMS).size();
    }

    public ItemPage viewItem(By element) {

        //driver won't allow test continue if more than 2 items presented longer than 5 sec (driverFunc)
        driverFunc.waitForElement(DRESS_ITEMS, 3);
        driverFunc.LOGGER.info(howMuchItemsFound() + " items found");
        driverFunc.findOneElement(element).click();
        //uncomment next line in case you are using chrome driver
        driverFunc.findOneElement(element).click();
        return new ItemPage(driverFunc);
    }
}
