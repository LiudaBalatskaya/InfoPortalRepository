package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.wd.WdConfig;
import org.junit.BeforeClass;
import org.junit.Test;

public class InfoPortalPage {

    @BeforeClass
    public static void setUp() {
        WdConfig.setUp();
    }


    @Test
    public void infoPortalPageHeader() {
        open("http://info.issoft.by");
    }


    @Test
    public void homeCards() {

    }
}
