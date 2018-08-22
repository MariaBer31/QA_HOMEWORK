package test_Definitions_Delfi;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import secondHometaskDelfi.pages.ArticlePage;
import secondHometaskDelfi.pages.BasicFunctions;
import secondHometaskDelfi.pages.CommentPage;
import secondHometaskDelfi.pages.HomePage;

public class DelfiStepDefs {
    HomePage homePage;
    ArticlePage articlePage;
    CommentPage commentPage;
    BasicFunctions basicFunctions = new BasicFunctions();
    private final String HOME_PAGE = "rus.delfi.lv";


    @Given("Delfi home page")
    public void open_home_page() {
        basicFunctions.openPage(HOME_PAGE);
        homePage = new HomePage(basicFunctions);
    }

    @When("we are searching for article with text (.*)")
    public void search(String articleText) {
        homePage.getArticleByText(articleText);
        articlePage = new ArticlePage(basicFunctions);
    }

    @Then("we are getting full article text and compare with article name on article page")
    public void checkArticlesName() {
        String titleAndCommentsOnArticlePage = articlePage.getTitleWithComments();
        Assert.assertEquals("Comments does not match", titleAndCommentsOnArticlePage, homePage.fullArticleText);
    }

    @Then("redirecting to comment page")
    public void redirectToCommentPage() {
        articlePage.openCommentPage();
        commentPage = new CommentPage(basicFunctions);
    }

    @Then("expect comment count is equals to comment count on main page")
    public void check_results() {
        Assert.assertSame("Comment count doesn't match", commentPage.commentSum(), basicFunctions.stringToInt(homePage.articleComment));
        basicFunctions.closeBrowser();
    }
}
