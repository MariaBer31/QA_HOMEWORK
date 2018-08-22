package home_classWork_dresses;

import home_classWork_dresses.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BuyDressesTest {
    private DriverFunc driverFunc = new DriverFunc();

    private final String HOMEPAGE = "automationpractice.com";
    private BigDecimal shipping_Price = new BigDecimal("2.00");

    @Test
    public void buyDresses() {
        driverFunc.openWebPage(HOMEPAGE);

        MainPage mainPage = new MainPage(driverFunc);

        WomenPage womenPage = mainPage.openWomenPage();

        DressesPage dressesPage = womenPage.choseFilter();
        dressesPage.choseColor();

        ItemPage itemPage = dressesPage.viewItem(dressesPage.ORANGE_1);
        String price1 = itemPage.purchasePrice();
        itemPage.buyDress();
        itemPage.returnToDressPage();

        dressesPage.choseColor();
        dressesPage.viewItem(dressesPage.ORANGE_2);
        String price2 = itemPage.purchasePrice();
        itemPage.buyDress();

        CartPage cartPage = itemPage.goToCart();
        cartPage.total_price();

        BigDecimal price_1 = driverFunc.stringPriceToBigDecimal(price1);
        BigDecimal price_2 = driverFunc.stringPriceToBigDecimal(price2);
        BigDecimal summ_without_shipping = price_1.add(price_2);
        BigDecimal sum_With_Shipping = shipping_Price.add(summ_without_shipping);

        //Checks that the summ of prices we saw in description of dresses + shipping price equals to total price in cart
        Assert.assertEquals("different prices!", 0, cartPage.total_price().compareTo(sum_With_Shipping));

        cartPage.add_items();

        BigDecimal doubleItems = summ_without_shipping.add(summ_without_shipping);
        BigDecimal allDressesAndShipping = doubleItems.add(shipping_Price);
        cartPage.total_price();
        driverFunc.LOGGER.info("calculated price =" + allDressesAndShipping + " actual price =" + cartPage.total_Price);
        //checks price after adding items
        Assert.assertEquals("different prices!", 0, cartPage.total_price().compareTo(allDressesAndShipping));

        driverFunc.closeWebPage();
    }
}
