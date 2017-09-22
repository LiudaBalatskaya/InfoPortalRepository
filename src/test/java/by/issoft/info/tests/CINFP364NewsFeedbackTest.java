package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import by.issoft.info.po.NewsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP364NewsFeedbackTest extends BaseTest {
    private static NewsPage newsPage;


    @BeforeClass
    public void openPage() {
        newsPage = open(NewsPage.URL, NewsPage.class);
    }


    @Test
    public void verifyVisibleFeedbackButton() {
        Assert.assertTrue(newsPage.getFeedback().isDisplayed(), "Feedback button isn't display");
    }


    @Test
    public void verifyActiveFeedbackButton() {
        WebDriver driver = getWebDriver();
        String winHandleBefore = driver.getWindowHandle();
        newsPage.getBody().sendKeys(Keys.PAGE_DOWN);
        newsPage.getFeedback().click();
        Assert.assertTrue(newsPage.getFeedback().isEnabled(), "Feedback button isn't active");
    }
}
