package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.NewsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP362NewsListTest extends BaseTest {
    private static NewsPage newsPage;


    @BeforeClass
    public void openPage() {
        newsPage = open(NewsPage.URL, NewsPage.class);
    }


    @Test
    public void verifyVisibleNewsList() {
        Assert.assertTrue(newsPage.getNewsList().isDisplayed(), "News list isn't display");
    }


    @Test
    public void verifyVisibleHeadingOfEachNews() {
        Assert.assertTrue(newsPage.getHeadingOfEachNews(), "Not all news visible  have visible heading");
    }


    @Test
    public void verifyVisibleDescriptionOfEachNews() {
        Assert.assertTrue(newsPage.getDescriptionOfEachNews(), "Not all news have visible brief description");
    }


    @Test
    public void verifyVisibleDateOfEachNews() {
        Assert.assertTrue(newsPage.getDateOfEachNews(), "Not all news have visible news date");
    }


    @Test
    public void verifyVisibleImageOfEachNews() {
        Assert.assertTrue(newsPage.getImageOfEachNews(), "Not all news have visible image");
    }


    @Test
    public void verifyActiveLinkOfEachNews() {

        Assert.assertTrue(newsPage.getLinkOfEachNews(), "Not all news have active link");
    }
}
