package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;

import by.issoft.info.config.Configurator;
import by.issoft.info.po.AboutPage;
import by.issoft.info.po.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomePageTest.class);


    @BeforeClass
    public static void setUp() {
        Configurator.setUp();
    }


    @Test
    public void cinfp350PageHeader() {
        SoftAssert softAssert = new SoftAssert();
        LOGGER.info("Open Home page");
        HomePage homePage = open(HomePage.getUrl(), HomePage.class);


        LOGGER.info("Verify Issoft-logo img");
        softAssert.assertTrue(homePage.getLogo().isDisplayed(), "ISSoft Logo is absent");


        LOGGER.info("Verify title");
        String actualPageTitle = title();
        String expectationPageTitle = "InfoPortal";
        softAssert.assertEquals(actualPageTitle, expectationPageTitle,
                "Wrong " + HomePage.class.getSimpleName() + " title. " +
                        "Expectation is '" + expectationPageTitle + "'. " +
                        "Actual is '" + actualPageTitle + "'.");


        LOGGER.info("Verify 'About company' ('О компании') navigation link");
        homePage.getAboutCompanyMenu().click();
        String expectedUrl = AboutPage.getUrl();
        String actualUrl = url();
        softAssert.assertEquals(actualUrl, expectedUrl, "'About company' ('О компании') menu link is wrong. " +
                AboutPage.class.getSimpleName() + " is not open.");


        //        LOGGER.info("Verify 'News' ('новости') navigation link");
        //        open(HomePage.PAGE_URL, HomePage.class);
        //        homePage.getAboutCompanyMenu().click();
        //        String expectedUrl = AboutPage.PAGE_URL;
        //        String actualUrl = url();
        //        collector.checkThat("'About company' ('О компании') menu link is wrong. " +
        //                AboutPage.class.getSimpleName() + " is not open.", actualUrl, is(expectedUrl));


        softAssert.assertTrue(false, "EXPERIMENT FAILED ");
        softAssert.assertAll();
    }


    @Test
    public void cinfp356HomeCards() {
        LOGGER.info("222222222222222222");
    }
}
