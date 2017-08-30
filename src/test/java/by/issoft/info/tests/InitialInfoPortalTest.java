package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.wd.WdConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class InitialInfoPortalTest {

    @BeforeClass
    public static void setUp() {
        WdConfig.setUp();
    }

    @Test
    public void initTestMethod() throws Exception {
        open("http://info.issoft.by");
        $(By.xpath("//a[text()='О компании']")).click();
    }
}
