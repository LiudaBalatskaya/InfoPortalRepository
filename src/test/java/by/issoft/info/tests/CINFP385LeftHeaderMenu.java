package by.issoft.info.tests;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

import by.issoft.info.po.GalleryPage;
import by.issoft.info.po.HomePage;
import by.issoft.info.po.HrBonusesPage;
import by.issoft.info.po.InnovationCenterPage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.RulesPage;
import by.issoft.info.po.SportPage;
import by.issoft.info.po.TeamPage;
import by.issoft.info.po.TrainingCenterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP385LeftHeaderMenu extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;


    @BeforeMethod
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
    }


    @Test()
    public void verifyQuantityOfMenuItem() {
        Assert.assertEquals(leftHeaderMenu.getQuantityOfMenuItems(), 11, "Quantity of Left Header MEnu items is wrong");
    }


    @Test()
    public void verifyGalleryMenuItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leftHeaderMenu.getGalleryIcon().isDisplayed(), "Gallery Icon is not displayed");
        leftHeaderMenu.getGalleryLink().click();
        softAssert.assertEquals(url(), baseUrl + GalleryPage.URL, GalleryPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }


    @Test()
    public void verifyTrainingCenterMenuItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leftHeaderMenu.getTrainingCenterIcon().isDisplayed(), "Training Icon is not displayed");
        leftHeaderMenu.getTrainingCenterLink().click();
        softAssert.assertEquals(url(), baseUrl + TrainingCenterPage.URL,
                TrainingCenterPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }


    @Test()
    public void verifyInnovationCenterMenuItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leftHeaderMenu.getInnovationCenterIcon().isDisplayed(), "Innovation Icon is not displayed");
        leftHeaderMenu.getInnovationCenterLink().click();
        softAssert.assertEquals(url(), baseUrl + InnovationCenterPage.URL,
                InnovationCenterPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }


    @Test()
    public void verifySportMenuItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leftHeaderMenu.getSportIcon().isDisplayed(), "Sport Icon is not displayed");
        leftHeaderMenu.getSportLink().click();
        softAssert.assertEquals(url(), baseUrl + SportPage.URL, SportPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }


    @Test()
    public void verifyHrBonusesMenuItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leftHeaderMenu.getHrBonusesIcon().isDisplayed(), "HR-Bonuses Icon is not displayed");
        leftHeaderMenu.getHrBonusesLink().click();
        softAssert.assertEquals(url(), baseUrl + HrBonusesPage.URL, HrBonusesPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }


    @Test()
    public void verifyTeamMenuItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leftHeaderMenu.getTeamIcon().isDisplayed(), "Team Icon is not displayed");
        leftHeaderMenu.getTeamLink().click();
        softAssert.assertEquals(url(), baseUrl + TeamPage.URL, TeamPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }


    @Test()
    public void verifyRulesMenuItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leftHeaderMenu.getRulesIcon().isDisplayed(), "Rules Icon is not displayed");
        leftHeaderMenu.getRulesLink().click();
        softAssert.assertEquals(url(), baseUrl + RulesPage.URL, RulesPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }
}
