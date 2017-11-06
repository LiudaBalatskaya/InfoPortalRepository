package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.SportPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP387SportNewsSectionTest extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;
    private static SportPage sportPage;


    @BeforeClass
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
        leftHeaderMenu.getSportLink().click();
        sportPage = new SportPage();
    }


    @Test
    public void verifyNewsHeader() {
        Assert.assertEquals(sportPage.getNewsHeader(), "НОВОСТИ СПОРТА", " Header <НОВОСТИ СПОРТА> is wrong");
    }


    @Test
    public void verifyNewsBlockVisible() {
        Assert.assertTrue(sportPage.getNewsBlock().isDisplayed(), "Block of News isn't visible");
    }


    @Test
    public void verifyCountNewsItems() {
        int count = sportPage.getCountNewsItem();
        Assert.assertTrue(count>0, "No news items in the news block on the page");
    }


    @Test()
    public void verifyVisibleMonthOfNewsItems() {
        Assert.assertTrue(sportPage.isMonthNewsItems(), "No month label in the news block on the page");
    }


    @Test()
    public void verifyVisibleRuleNumbersOfNewsItems() {
        Assert.assertTrue(sportPage.isRuleNumbersOfNews(), "No rule number near the news topic on the page");
    }


    @Test()
    public void verifyVisibleBriefTitleOfNewsTopics() {
        Assert.assertTrue(sportPage.isBriefTitleOfNews(), "No brief title of news topic on the page");
    }


    @Test()
    public void verifyVisibleAllNewsLink() {
        Assert.assertTrue(sportPage.getAllNews().isDisplayed(), "No visible all news link");
    }
}
