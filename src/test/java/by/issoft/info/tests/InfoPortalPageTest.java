package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.core.Is.is;

import by.issoft.info.po.AboutPage;
import by.issoft.info.po.HomePage;
import by.issoft.info.wd.WdConfig;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;


public class InfoPortalPageTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();


    @BeforeClass
    public static void setUp() {
        WdConfig.setUp();
    }


    @Test
    public void infoPortalPageHeader() {
        HomePage homePage = open(HomePage.getUrl(), HomePage.class);
        collector.checkThat("ISSoft Logo is absent", homePage.getLogo().isDisplayed(), is(true));


        String actualPageTitle = title();
        String expectationPageTitle = "InfoPortal";
        collector.checkThat("Wrong " + HomePage.class.getSimpleName() + " title. " +
                "Expectation is '" + expectationPageTitle + "'. " +
                "Actual is '" + actualPageTitle + "'.", actualPageTitle, is(expectationPageTitle));


        homePage.getAboutCompanyMenu().click();
        String expectedUrl = AboutPage.getUrl();
        String actualUrl = url();
        collector.checkThat("'О компании' menu link is wrong. " +
                AboutPage.class.getSimpleName() + " is not open.", actualUrl, is(expectedUrl));


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
