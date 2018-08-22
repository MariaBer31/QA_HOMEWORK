package secondHometaskDelfi.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ArticlePage {
    private final By COMMENT_LINK = By.xpath(".//div[@class = 'article-title']/a");
    private final By TITLE_WITH_COMMENTS = By.xpath(".//div[@class=\"article-title\"]");

    private BasicFunctions basicFunctions;
    public final Logger LOGGER = LogManager.getLogger(ArticlePage.class);

    public ArticlePage(BasicFunctions basicFunctions) {
        this.basicFunctions = basicFunctions;
    }

    public String getTitleWithComments() {
        return basicFunctions.getElement(TITLE_WITH_COMMENTS).getText();
    }

    public CommentPage openCommentPage() {
        basicFunctions.getElement(COMMENT_LINK).click();
        LOGGER.info("Redirecting to comment page");
        return new CommentPage(basicFunctions);
    }
}
