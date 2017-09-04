package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.core.Is.is;

import by.issoft.info.config.Configurator;
import by.issoft.info.po.AboutPage;
import by.issoft.info.po.HomePage;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InfoPortalPageTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(InfoPortalPageTest.class);

    @Rule
    public ErrorCollector collector = new ErrorCollector();


    @BeforeClass
    public static void setUp() {
        Configurator.setUp();
    }


    @Test
    public void infoPortalPageHeader() {
        LOGGER.info("Open Home page");
        HomePage homePage = open(HomePage.getUrl(), HomePage.class);
        collector.checkThat("ISSoft Logo is absent", homePage.getLogo().isDisplayed(), is(true));

        LOGGER.info("Verify Issoft-logo img");
        String actualPageTitle = title();
        String expectationPageTitle = "InfoPortal";
        collector.checkThat("Wrong " + HomePage.class.getSimpleName() + " title. " +
                "Expectation is '" + expectationPageTitle + "'. " +
                "Actual is '" + actualPageTitle + "'.", actualPageTitle, is(expectationPageTitle));

        LOGGER.info("Verify 'О компании' navigation link");
        homePage.getAboutCompanyMenu().click();
        String expectedUrl = AboutPage.getUrl();
        String actualUrl = url();
        collector.checkThat("'О компании' menu link is wrong. " +
                AboutPage.class.getSimpleName() + " is not open.", actualUrl, is(expectedUrl));

        //        LOGGER.info("Verify 'новости' navigation link");
        //        open(HomePage.PAGE_URL, HomePage.class);
        //        homePage.getAboutCompanyMenu().click();
        //        String expectedUrl = AboutPage.PAGE_URL;
        //        String actualUrl = url();
        //        collector.checkThat("'О компании' menu link is wrong. " +
        //                AboutPage.class.getSimpleName() + " is not open.", actualUrl, is(expectedUrl));


        collector.checkThat("EXPERIMENT FAILED ", true, is(false));
    }


    @Test
    public void homeCards() {

    }
}
