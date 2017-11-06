package by.issoft.info.tests;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

import by.issoft.info.po.AboutCompanyPage;
import by.issoft.info.po.NewsPage;
import by.issoft.info.po.SocialPackagePage;
import by.issoft.info.po.TeamPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP403SocialPackageHeaderTest extends BaseTest {
    private static SocialPackagePage socialPage;


    @BeforeMethod
    public void openPage() {
        socialPage = open(SocialPackagePage.URL, SocialPackagePage.class);
    }

    @Test
    public void verifyISsoftLogo() {
        Assert.assertTrue(socialPage.getISsoftLogo().isDisplayed(), "ISSoft Logo is absent");
    }


    @Test
    public void verifyTitle() {
        Assert.assertEquals(title(), "InfoPortal",
                "Wrong " + SocialPackagePage.class.getSimpleName() + " title. ");
    }


    @Test
    public void verifyISsoftCoherentLogo() {
        Assert.assertTrue(socialPage.getCoherentLogo().isDisplayed(), "Coherent Logo is absent");
    }


    @Test
    public void verifyBracketedTitle() {
        Assert.assertEquals(socialPage.getBracketedTitle(), "СОЦИАЛЬНЫЙ ПАКЕТ", " Bracketed title is wrong");
    }

    @Test
    public void verifyAboutCompanyHeaderLink() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(socialPage.getAboutCompanyHeaderLink().getText(), "О КОМПАНИИ", "Header item of social page is wrong");
        socialPage.getAboutCompanyHeaderLink().click();
        assertEquals(url(), baseUrl + AboutCompanyPage.URL, "'About company' ('О компании') header link is wrong");
        softAssert.assertAll();
    }


    @Test
    public void verifyTeamHeaderLink() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(socialPage.getTeamHeaderLink().getText(), "КОМАНДА", "Header item of social page is wrong");
        socialPage.getTeamHeaderLink().click();
        assertEquals(url(), baseUrl + TeamPage.URL, "'Team' ('Команда') header link is wrong");
        softAssert.assertAll();
    }


    @Test
    public void verifyVisibleNewsHeaderLink() {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(socialPage.getNewsHeaderLink().isDisplayed(), "'News' ('Новости') header link isn't displayed");
        socialPage.getNewsHeaderLink().click();
        assertEquals(url(), baseUrl + NewsPage.URL, "'News' ('Новости') header link is wrong");
        softAssert.assertAll();
    }
}
