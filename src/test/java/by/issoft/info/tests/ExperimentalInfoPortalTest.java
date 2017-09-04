package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.config.Configurator;
import by.issoft.info.po.HomePage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class ExperimentalInfoPortalTest {

    @BeforeClass
    public static void setUp() {
        Configurator.setUp();
    }


    @Test
    public void experimentalTestMethod() {
        HomePage homePage = open("http://info.issoft.by", HomePage.class);
        $(By.xpath("//a[text()='О компании']")).click();
    }


    @Test
    public void experiment2() {
        HomePage homePage = open("http://info.issoft.by", HomePage.class);
    }
}
