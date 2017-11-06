package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

import by.issoft.info.po.BonusesDiscountsPage;
import by.issoft.info.po.HomePage;
import by.issoft.info.po.RulesPage;
import by.issoft.info.po.SocialPackagePage;
import by.issoft.info.po.SportPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP383BottomCardRowHomePageTest extends BaseTest {
    private static HomePage homePage;
    private static RulesPage rulesPage;
    private static SocialPackagePage socialPackagePage;
    private static SportPage sportPage;
    private static BonusesDiscountsPage bonusPage;


    @BeforeMethod
    public void openHomePage() {
        homePage = open(HomePage.URL, HomePage.class);
    }


    @Test()
    public void verifyVisibleBottomCardRom() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getRules().isDisplayed(), "Rules block isn't displayed");
        softAssert.assertTrue(homePage.getRules().$("h2").getText().contains("ПРАВИЛА"), "Title of rules block is wrong");
        softAssert.assertTrue(homePage.getRules().$("h3").getText().contains("внутреннего распорядка"), "Title of rules block is wrong");

        softAssert.assertTrue(homePage.getSocialPackage().isDisplayed(), "Social package block isn't displayed");
        softAssert.assertTrue(homePage.getSocialPackage().$("h2").getText().contains("СОЦИАЛЬНЫЙ ПАКЕТ"), "Title of social package block is wrong");
        softAssert.assertTrue(homePage.getSocialPackage().$("h3").getText().contains("сотрудников компании"), "Title of social package block is wrong");

        softAssert.assertTrue(homePage.getInfoSecurity().isDisplayed(), "InfoSecurity block isn't displayed");
        softAssert.assertTrue(homePage.getInfoSecurity().$("h2").getText().contains("ИНФОРМАЦИОННАЯ БЕЗОПАСНОСТЬ"), "Title of InfoSecurity block is wrong");
        softAssert.assertTrue(homePage.getInfoSecurity().$("h3").getText().contains("для защиты данных"), "Title of InfoSecurity block is wrong");

        softAssert.assertTrue(homePage.getSportBlock().isDisplayed(), "Sport block isn't displayed");
        softAssert.assertTrue(homePage.getSportBlock().$("h2").getText().contains("СПОРТ"), "Title of sport block is wrong");
        softAssert.assertTrue(homePage.getSportBlock().$(".sport-image").isDisplayed(), "Sport image isn't displayed");

        softAssert.assertTrue(homePage.getBonusesBlock().isDisplayed(), "Bonus block isn't displayed");
        softAssert.assertTrue(homePage.getBonusesBlock().$("h2").getText().contains("БОНУСЫ"), "Title of bonus block is wrong");
        softAssert.assertTrue(homePage.getBonusesBlock().$("h2").getText().contains("И СКИДКИ"), "Title of bonus block is wrong");
        softAssert.assertTrue(homePage.getBonusesBlock().$(".bonuses-image").isDisplayed(), "Bonus image isn't displayed");

        softAssert.assertTrue(homePage.getFeedback().isDisplayed(), "Feedback button isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveBottomCardRomLinks() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(homePage.getRulesLink().getAttribute("href").contains("/rules"), "Link of the rules is wrong");
        homePage.getRules().click();
        sleep(2000);
        rulesPage = new RulesPage();
        softAssert.assertTrue(url().toString().contains(rulesPage.URL), "Link of all rules isn't active");
        navigator.back();
        sleep(2000);

        softAssert.assertTrue(homePage.getSocialPackageLink().getAttribute("href").contains("/social-package"), "Link of the social package is wrong");
        homePage.getSocialPackage().click();
        sleep(2000);
        socialPackagePage = new SocialPackagePage();
        softAssert.assertTrue(url().toString().contains(socialPackagePage.URL), "Link of social package isn't active");
        navigator.back();
        sleep(2000);

        softAssert.assertTrue(homePage.getSportLink().getAttribute("href").contains("/sport"), "Link of the sport is wrong");
        homePage.getSportBlock().click();
        sleep(2000);
        sportPage = new SportPage();
        softAssert.assertTrue(url().toString().contains(sportPage.URL), "Link of sport isn't active");
        navigator.back();
        sleep(2000);


        softAssert.assertTrue(homePage.getBonusesLink().getAttribute("href").contains("/bonuses-and-discounts"), "Link of the social package is wrong");
        homePage.getBonusesBlock().click();
        sleep(2000);
        bonusPage = new BonusesDiscountsPage();
        softAssert.assertTrue(url().toString().contains(bonusPage.URL), "Link of bonus isn't active");
        navigator.back();
        sleep(2000);

        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveInfoSecurityLinks() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(homePage.getInfoSecurityLink().getAttribute("href").contains("https://coherentsolutions.sharepoint.com/sites"),
                "Link of the info security is wrong");
        homePage.switchToLoadedPage(homePage.getInfoSecurity());
        sleep(2000);
        WebDriver driver = getWebDriver();
        String currentUrl = driver.getCurrentUrl();
        //softAssert.assertEquals(securityPage.getTitle(),"Home - Information Security" ,"Link of security isn't active");
        softAssert.assertTrue(currentUrl.contains("https://login.microsoftonline.com"), "Link of security isn't active");
    }
}
