package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExperimentalInfoPortalTest extends BaseTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomePageTest.class);

    @Test
    public void experimentalTestMethod() {
        LOGGER.info("Experiment 1111111111111");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true, "Success 1");
        softAssert.assertTrue(true, "Success 2");
        softAssert.assertTrue(false, "Failure 1");
        softAssert.assertTrue(true, "Success 3");
        softAssert.assertTrue(false, "Failure 2");
        softAssert.assertAll();

        HomePage homePage = open("http://info.issoft.by", HomePage.class);
        $(By.xpath("//a[text()='О компании']")).click();
    }


    @Test
    public void experiment2() {
        HomePage homePage = open("http://info.issoft.by", HomePage.class);
    }
}
