package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.SocialPackagePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP414HealthInsuranceModalTest extends BaseTest {

    private static SocialPackagePage socialPage;


    @BeforeMethod
    public void openPage() {
        socialPage = open(SocialPackagePage.URL, SocialPackagePage.class);
    }


    @Test
    public void verifyHealthInsuranceModal() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(socialPage.getHealthInsurancesItem().isDisplayed(), " Health Insurance item isn't displayed");
        socialPage.getHealthInsurancesItem().click();
        socialPage.getModalBlock().isDisplayed();
        softAssert.assertTrue(socialPage.getModalBlock().isDisplayed(), " Modal block of Health Insurance item isn't displayed");
        softAssert.assertEquals(socialPage.getModalBlock().$("h1").getText(), "Медицинское страхование", " Modal block title of Health Insurance item is wrong");
        softAssert.assertTrue(socialPage.isVisibleCorrectDescriptionHealthModal(), " Descriptions of Health Insurance Modal is wrong");
        softAssert.assertTrue(socialPage.getModalBlock().$("img").isDisplayed(), " Officials photo of Health Insurance isn't displayed");
        softAssert.assertTrue(socialPage.getModalBlock().$("span").isDisplayed(), " Officials name of Health Insurance isn't displayed");
        softAssert.assertEquals(socialPage.getModalBlock().$("span").getText(), "Kira Katonova", " Officials name of Health Insurance is wrong");
        softAssert.assertTrue(socialPage.getModalBlock().$("a").getAttribute("href").contains("https://rmsys.issoft.by/Individual/Index#id"),
                " Officials name of Health Insurance isn't displayed");
        socialPage.getModalBlock().$(" .close-icon").isDisplayed();
        socialPage.getModalBlock().$(" .close-icon").click();
        softAssert.assertAll();
    }
}