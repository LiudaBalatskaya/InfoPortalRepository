package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.screenshot;

import by.issoft.info.allure.AllureAttacher;
import by.issoft.info.config.Configurator;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUpTestSuite() {
        Configurator.configure();
    }


    public void makeScreen() {
        screenshot("last_screen");
        AllureAttacher.attachScreen();
    }
}
