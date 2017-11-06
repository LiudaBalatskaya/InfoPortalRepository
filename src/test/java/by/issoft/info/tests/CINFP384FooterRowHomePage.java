package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP384FooterRowHomePage extends BaseTest {
    private static HomePage homePage;


    @BeforeMethod
    public void openHomePage() {
        homePage = open(HomePage.URL, HomePage.class);
    }


    @Test()
    public void verifyVisibleFootHomePage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getFootIssoft().isDisplayed(), "Foot ISsoft isn't displayed");
        softAssert.assertTrue(homePage.getFootIssoft().$("a").getAttribute("href").contains("#"), "Foot ISsoft isn't active");

        softAssert.assertTrue(homePage.getFootIssoftBy().isDisplayed(), "Foot ISsoft.by isn't displayed");
        softAssert.assertTrue(homePage.getFootIssoftBy().$("a").getAttribute("href").contains("http://www.issoft.by"), "Foot ISsoft.by isn't active");

        softAssert.assertTrue(homePage.getFootCoherent().isDisplayed(), "Foot coherentsolutions isn't displayed");
        softAssert.assertTrue(homePage.getFootCoherent().$("a").getAttribute("href").contains("http://www.coherentsolutions.com"), "Foot coherentsolutions isn't active");

        softAssert.assertTrue(homePage.getFootRMSYS().isDisplayed(), "Foot RMSYS isn't displayed");
        softAssert.assertTrue(homePage.getFootRMSYS().$("a").getAttribute("href").contains("https://rmsys.issoft.by"), "Foot RMSYS isn't active");

        softAssert.assertTrue(homePage.getFootIntacct().isDisplayed(), "Foot Intacct isn't displayed");
        softAssert.assertTrue(homePage.getFootIntacct().$("a").getAttribute("href").contains("https://time.coherentsolutions.com"), "Foot Intacct isn't active");

        softAssert.assertTrue(homePage.getFootLunchVoiting().isDisplayed(), "Foot Lunch Voting isn't displayed");
        softAssert.assertTrue(homePage.getFootLunchVoiting().$("a").getAttribute("href").contains("https://lunchvoting.issoft.by"), "Foot Lunch Voting isn't active");

        softAssert.assertTrue(homePage.getFootDocuments().isDisplayed(), "Foot Lunch Voting isn't displayed");
        softAssert.assertTrue(homePage.getFootDocuments().$("a").getAttribute("href").contains("https://coherentsolutions.sharepoint.com/sites/corporate"),
                "Foot Lunch Voting isn't active");
        softAssert.assertAll();
    }


    @Test()
    public void verifyVisibleActiveSocialIcons() {
        Assert.assertTrue(homePage.isVisibleActiveSocialIcons(), "Social icons on the foot aren't active");
    }
}
