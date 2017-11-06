package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.SportPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP388SportPageFeedbackTest extends BaseTest {
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
    public void verifyVisibleFeedbackButton() {
        Assert.assertTrue(sportPage.getFeedback().isDisplayed(), "Feedback button isn't display");
    }


    @Test
    public void verifyActiveFeedbackButton() {
        WebDriver driver = getWebDriver();
        String winHandleBefore = driver.getWindowHandle();
        sportPage.getBody().sendKeys(Keys.PAGE_DOWN);
        sportPage.getFeedback().click();
        Assert.assertTrue(sportPage.getFeedback().isEnabled(), "Feedback button isn't active");
    }
}
