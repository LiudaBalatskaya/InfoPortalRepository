package by.issoft.info.tests;

import by.issoft.info.config.Configurator;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUpTestSuite() {
        Configurator.configure();
    }
}
