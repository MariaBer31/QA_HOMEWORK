package secondHometaskDelfi.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By COMMENTS = By.className("comment-count");
    private final By ARTICLES = By.xpath("//h3[@class=\"top2012-title\"]");
    public String fullArticleText;
    public String articleComment;

    private BasicFunctions basicFunctions;
    public final Logger LOGGER = LogManager.getLogger(HomePage.class);

    public HomePage(BasicFunctions basicFunctions) {
        this.basicFunctions = basicFunctions;
    }

    public ArticlePage getArticleByText(String text) {
        WebElement webElement;
        for (int i = 0; i < allArticlesWithComments().size(); i++) {
            if (allArticlesWithComments().get(i).getText().contains(text)) {
                webElement = allArticlesWithComments().get(i);
                fullArticleText = webElement.getText();
                articleComment = webElement.findElement(COMMENTS).getText();
                LOGGER.info("Article with text " + text + "is found. Full article text: " + fullArticleText);
                LOGGER.info("Article comments: " + articleComment);
                LOGGER.info("Redirecting to Article page");
                webElement.click();
                break;
            }
        }
        return new ArticlePage(basicFunctions);
    }

    private List<WebElement> allArticlesWithComments() {
        return basicFunctions.getElements(ARTICLES);
    }
}
