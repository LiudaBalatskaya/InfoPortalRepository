package by.issoft.info;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;

public class InitialInfoPortalTest {

    @Test
    public void initTestMethod() throws Exception {
        //        System.setProperty("webdriver.gecko.driver", "C:\\_WebDriver\\geckodriver-v0.18.0-win64\\geckodriver.exe");
        //        Configuration.browser = "marionette";

        //        System.setProperty("webdriver.chrome.driver", "C:\\_WebDriver\\chrome_2.31\\chromedriver.exe");
        //        Configuration.browser = "chrome";

        Configuration.browser = "by.issoft.info.wd.ChromeRemoteWebDriverProvider";

        open("http://info.issoft.by");
        $(By.xpath("//a[text()='О компании']")).click();
    }
}
