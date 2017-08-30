package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.core.Is.is;

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
        HomePage homePage = open("http://info.issoft.by", HomePage.class);
        collector.checkThat("ISSoft Logo is absent", homePage.isLogoDisplayed(), is(true));
        collector.checkThat("", false, is(true));
        collector.checkThat("", false, is(true));
    }


    @Test
    public void homeCards() {

    }
}
