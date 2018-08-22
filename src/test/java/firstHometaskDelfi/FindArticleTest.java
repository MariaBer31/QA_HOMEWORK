package firstHometaskDelfi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class FindArticleTest {
    private final String MAIN_PAGE = "http://rus.delfi.lv/";
    private static final String NAME_ARTICLE = "Маршрут выходного дня";
    private final By NEWS_ITEM = By.xpath(".//a");
    private BaseSteps baseSteps = new BaseSteps();

    @Test
    public void findNewsTest() {
        baseSteps.openPage(MAIN_PAGE);
        Assert.assertFalse("No elements found", baseSteps.findListOfElements(NEWS_ITEM).isEmpty());
        Assert.assertTrue("No article found", baseSteps.isArticleFound(NAME_ARTICLE, NEWS_ITEM));
        baseSteps.closePage();
    }
}

