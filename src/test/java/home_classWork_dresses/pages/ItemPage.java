package home_classWork_dresses.pages;

import org.openqa.selenium.By;

public class ItemPage {
    private DriverFunc driverFunc;

    ItemPage(DriverFunc driverFunc) {
        this.driverFunc = driverFunc;
    }

    private final By PRICE = By.id("our_price_display");
    private final By ADD_TO_CHART = By.name("Submit");
    private final By CLOSE = By.className("cross");
    private final By BACK_TO_DRESSES = By.xpath("//div[@class=\"breadcrumb clearfix\"]/a");
    private final String DRESSES = "Dresses";
    private final By CART = By.xpath("//div[@class=\"shopping_cart\"]/a");

    public String purchasePrice() {
        return driverFunc.findOneElement(PRICE).getText();
    }

    public void buyDress() {
        driverFunc.LOGGER.info("It's time for shopping! I'll buy this dress!");
        driverFunc.findOneElement(ADD_TO_CHART).click();
        driverFunc.findOneElement(CLOSE).click();
    }

    public void returnToDressPage() {
        driverFunc.LOGGER.info("What else on dresses page?...redirecting...");
        driverFunc.chooseElement(driverFunc.findElements(BACK_TO_DRESSES), DRESSES);
    }

    public CartPage goToCart() {
        driverFunc.LOGGER.info("redirecting to cart");
        driverFunc.findOneElement(CART).click();
        return new CartPage(driverFunc);
    }
}
