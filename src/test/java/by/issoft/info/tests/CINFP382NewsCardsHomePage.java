package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.NewsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP382NewsCardsHomePage extends BaseTest {
    private static HomePage homePage;
    private static NewsPage newsPage;


    @BeforeClass
    public void openHomePage() {
        homePage = open(HomePage.URL, HomePage.class);
    }


    @Test()
    public void verifyNewsBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getNewsBlock().isDisplayed(), "News block isn't displayed");
        softAssert.assertEquals(homePage.getNewsBlock().$("h2").getText(), "НОВОСТИ КОМПАНИИ", "Title of news block is wrong");
        softAssert.assertTrue(homePage.isVisibleCorrectMonthNews(), "Months on the news block are wrong");
        softAssert.assertTrue(homePage.isVisibleNumbersNewsItems(), "Numbers Of news on the news block aren't displayed");
        softAssert.assertTrue(homePage.isVisibleNewsItemTitles(), "Titles Of news on the news block aren't displayed");
        softAssert.assertEquals(homePage.getAllNewsLink().$("a").getText(), "Все новости", "All news title of news block is wrong");
        softAssert.assertTrue(homePage.getAllNewsLink().$("a").getAttribute("href").contains("/news"), "Link of the all news item on news block is wrong");
        homePage.getAllNewsLink().click();
        sleep(2000);
        newsPage = new NewsPage();
        softAssert.assertTrue(url().toString().contains(newsPage.URL), "Link of all news isn't active");
        navigator.back();
        sleep(2000);
        softAssert.assertAll();
    }
}
