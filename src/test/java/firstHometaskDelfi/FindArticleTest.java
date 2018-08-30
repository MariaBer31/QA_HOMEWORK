package firstHometaskDelfi;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class FindArticleTest {
    private final String MAIN_PAGE = "http://rus.delfi.lv/";
    private static final String NAME_ARTICLE = "Бесплатной медицины в Латвии стало меньше";
    private BaseSteps baseSteps = new BaseSteps();

    @Test
    public void findNewsTest() {
        baseSteps.openPage(MAIN_PAGE);
        MainPage mainPage = new MainPage(baseSteps);
        Assert.assertFalse("No elements found", mainPage.newsItems().isEmpty());
        Assert.assertTrue("No article found", baseSteps.isArticleFound(NAME_ARTICLE, mainPage.NEWS_ITEM));
    }

    @After
    public void closePage() {
        baseSteps.closePage();
    }
}

