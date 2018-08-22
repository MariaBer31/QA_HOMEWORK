package secondHometaskDelfi;

import org.junit.Assert;
import org.junit.Test;
import secondHometaskDelfi.pages.ArticlePage;
import secondHometaskDelfi.pages.BasicFunctions;
import secondHometaskDelfi.pages.CommentPage;
import secondHometaskDelfi.pages.HomePage;

public class DelfiPageObjectTest {
    private BasicFunctions basicFunctions = new BasicFunctions();
    private final String HOME_PAGE = "rus.delfi.lv";
    String ARTICLE_TEXT = "В Латвии аннулировали бренд";


    /*Для заданной статьи проверить, что совпадает количество комментариев на DelfiWeb главной странице,
     странице самой статьи, и странице комментариев (посчитав комментарии)*/

    @Test
    public void calculateComments() {
        basicFunctions.openPage(HOME_PAGE);
        HomePage homePage = new HomePage(basicFunctions);
        ArticlePage articlePage = homePage.getArticleByText(ARTICLE_TEXT);

        //Checks text of Article on main page and article page (with comments)
        String titleAndCommentsOnArticlePage = articlePage.getTitleWithComments();
        Assert.assertEquals("Comments does not match", titleAndCommentsOnArticlePage, homePage.fullArticleText);

        Integer mainPageCommentsCount = basicFunctions.stringToInt(homePage.articleComment);

        CommentPage commentPage = articlePage.openCommentPage();

        //checks comment count from Comment Page and Home page
        Integer commentPageCommentSum = commentPage.commentSum();
        Assert.assertSame("Comments number is different", commentPageCommentSum, mainPageCommentsCount);

        basicFunctions.closeBrowser();
    }
}
