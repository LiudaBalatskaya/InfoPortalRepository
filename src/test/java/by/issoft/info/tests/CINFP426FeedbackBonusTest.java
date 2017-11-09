package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import by.issoft.info.po.HrBonusesPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP426FeedbackBonusTest extends BaseTest {
    private static HrBonusesPage hrBonusesPage;


    @BeforeMethod
    public void openPage() {
        hrBonusesPage = open(HrBonusesPage.URL, HrBonusesPage.class);
    }

    @Test
    public void verifyVisibleFeedbackButton() {
        Assert.assertTrue(hrBonusesPage.getHRFeedback().isDisplayed(), "Feedback button isn't display");
    }


    @Test
    public void verifyActiveHRFeedbackButton() {
        WebDriver driver = getWebDriver();
        String winHandleBefore = driver.getWindowHandle();
        hrBonusesPage.getBody().sendKeys(Keys.PAGE_DOWN);
        hrBonusesPage.getHRFeedback().click();
        Assert.assertTrue(hrBonusesPage.getFeedback().isEnabled(), "Feedback button isn't active");
    }
}
