package secondHometaskDelfi.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CommentPage {
    private final By COMMENT_PAGE_TITLE = By.xpath(".//a[@class = 'comment-main-title-link']");
    private final By COMMENT_REG = By.xpath("//a[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']");
    private final By COMMENT_UNREG = By.xpath("//a[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-anon']");


    private BasicFunctions basicFunctions;
    public final Logger LOGGER = LogManager.getLogger(CommentPage.class);

    public CommentPage(BasicFunctions basicFunctions) {
        this.basicFunctions = basicFunctions;
    }

    public String getTitle() {
        return basicFunctions.getElement(COMMENT_PAGE_TITLE).getText();
    }

    private String getCommentsPartOne() {
        return basicFunctions.getElement(COMMENT_REG).getText().substring(basicFunctions.getElement(COMMENT_REG).getText().length() - 3);
    }

    private String getCommentsPartTwo() {
        return basicFunctions.getElement(COMMENT_UNREG).getText().substring(basicFunctions.getElement(COMMENT_UNREG).getText().length() - 3);
    }

    public int commentSum() {
        int commentReg = basicFunctions.stringToInt(getCommentsPartOne());
        int commentUnreg = basicFunctions.stringToInt(getCommentsPartTwo());
        LOGGER.info("Registered comments: " + commentReg + " /unregistered comments: " + commentUnreg);

        return commentReg + commentUnreg;
    }
}
