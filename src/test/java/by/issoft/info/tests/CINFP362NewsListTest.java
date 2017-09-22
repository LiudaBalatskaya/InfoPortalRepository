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
    public void verifyVisibleHeadingsOfNews() {
        Assert.assertTrue(newsPage.isVisibleHeadingsOfNews(), "Not all news visible  have visible heading");
    }


    @Test
    public void verifyVisibleDescriptionsOfNews() {
        Assert.assertTrue(newsPage.isVisibleDescriptionsOfNews(), "Not all news have visible brief description");
    }


    @Test
    public void verifyVisibleDatesOfNews() {
        Assert.assertTrue(newsPage.isVisibleDatesOfNews(), "Not all news have visible news date");
    }


    @Test
    public void verifyVisibleImagesOfNews() {
        Assert.assertTrue(newsPage.isVisibleImagesOfNews(), "Not all news have visible image");
    }


    @Test
    public void verifyActiveLinksNews() {
        Assert.assertTrue(newsPage.isActiveLinksOfNews(), "Not all news have active link");
    }
}