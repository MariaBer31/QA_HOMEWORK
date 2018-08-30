package homeClassWorkDresses.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

public class CartPage {
    private DriverFunc driverFunc;

    private final By TOTAL_PRICE = By.id("total_price");
    private final By ADD_ICON = By.xpath("//i[@class=\"icon-plus\"]");
    private final By QUANTITY = By.id("summary_products_quantity");
    private final String EXPECTED_RESULT = "4 Products";
    public BigDecimal total_Price;

    CartPage(DriverFunc driverFunc) {
        this.driverFunc = driverFunc;
    }

    public BigDecimal total_price() {
        total_Price = driverFunc.stringPriceToBigDecimal(driverFunc.findOneElement(TOTAL_PRICE).getText());
        return total_Price;
    }

    public void add_items() {
        driverFunc.LOGGER.info("I want some more dresses. Adding items");
        List<WebElement> items = driverFunc.findElements(ADD_ICON);
        for (WebElement item : items) {
            item.click();
        }
        driverFunc.waitConditionTextToBe(QUANTITY, EXPECTED_RESULT);
    }
}
