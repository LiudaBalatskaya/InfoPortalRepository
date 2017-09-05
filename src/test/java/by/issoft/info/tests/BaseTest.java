package by.issoft.info.tests;

import static com.codeborne.selenide.Configuration.baseUrl;

import by.issoft.info.wd.WdConfig;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUpTestSuite() {
        /* log4j config*/
        PropertyConfigurator.configure(".\\src\\test\\resources\\log4j.properties");


        /* selenide config */
        //        baseUrl = PropertyLoader.loadProperty("site.url");
        baseUrl = "http://info.issoft.by";


        /* WebDriver config*/
        WdConfig.setUp();
    }
}
