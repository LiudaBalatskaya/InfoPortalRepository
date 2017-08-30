package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import by.issoft.info.wd.WdConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class ExperimentalInfoPortalTest {

    @BeforeClass
    public static void setUp() {
        WdConfig.setUp();
    }

    @Test
    public void experimentalTestMethod() {
        HomePage homePage = open("http://info.issoft.by", HomePage.class);
        $(By.xpath("//a[text()='О компании']")).click();
    }
}
