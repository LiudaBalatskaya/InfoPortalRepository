package by.issoft.info.wd;

import com.codeborne.selenide.Configuration;

public class WdConfig {

    public static void setUp() {
        // move configuration in special class before all test or use
        // system property "-Dselenide.browser=chrome" and "marionette"
        // put XXXXXXdriver.exe files into

        //        System.setProperty("webdriver.gecko.driver", "C:\\_WebDriver\\geckodriver-v0.18.0-win64\\geckodriver.exe");
        //        Configuration.browser = "marionette";

        System.setProperty("webdriver.chrome.driver", "C:\\_WebDriver\\chrome_2.31\\chromedriver.exe");
        Configuration.browser = "chrome"; // Compatible with browser Version 60.0.3112.101

        //        Configuration.browser = "by.issoft.info.wd.ChromeRemoteWebDriverProvider";
    }
}
