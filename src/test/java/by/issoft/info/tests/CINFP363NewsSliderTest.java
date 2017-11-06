package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

import by.issoft.info.po.NewsPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP363NewsSliderTest extends BaseTest {
    private static NewsPage newsPage;


    @BeforeMethod
    public void openPage() {
        newsPage = open(NewsPage.URL, NewsPage.class);
    }


    @Test
    public void verifyVisibleNewsSlide() {
        Assert.assertTrue(newsPage.getActiveSlide().isDisplayed(), "Slider's news isn't display");
    }


    @Test
    public void verifyVisibleNextButton() {
        Assert.assertTrue(newsPage.getNextButton().isDisplayed(), "Next button isn't display");
    }


    @Test
    public void verifyVisiblePreviousButton() {
        Assert.assertTrue(newsPage.getPreviousButton().isDisplayed(), "Previous button isn't display");
    }


    @Test
    public void verifySlideNewsAfterClickNext() {

        String eventTitle = newsPage.getTitleOfActiveSlide();
        newsPage.getBody().sendKeys(Keys.PAGE_DOWN);
        newsPage.clickNextButton();
        sleep(2000);
        newsPage.getBody().sendKeys(Keys.PAGE_UP);
        newsPage.getBody().sendKeys(Keys.CONTROL, "-");
        sleep(2000);
        Assert.assertNotEquals(newsPage.getTitleOfActiveSlide(), eventTitle, "Slide was not change after click at the button Next");
    }


    @Test
    public void verifySlideNewsAfterClickPrevious() {
        String curentTitle = newsPage.getTitleOfActiveSlide();
        newsPage.getBody().sendKeys(Keys.PAGE_DOWN);
        newsPage.clickPreviousButton();
        sleep(3000);
        String previousTitle = newsPage.getTitleOfActiveSlide();
        Assert.assertNotEquals(previousTitle, curentTitle, "Slide was not change after click the button Previous");
    }
}
