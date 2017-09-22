package by.issoft.info.wd;

import by.issoft.info.config.Prop;
import by.issoft.info.config.PropKey;
import by.issoft.info.exceptions.AutotestConfigException;
import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WdConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(WdConfig.class);


    public static void configure() {
        LOGGER.info("-----------------------------------------");
        String browser = Prop.getProp(PropKey.BROWSER);

        switch (browser) {
            case "local_chrome":
                LOGGER.info("Starting local chrome browser");
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    System.setProperty("webdriver.chrome.driver", Prop.getProp(PropKey.WEBDRIVER_CHROME_DRIVER));
                }
                Configuration.browser = "chrome";
                Configuration.startMaximized = true;
                // Configuration.browserSize = "1400x1050";
                Configuration.browserSize = "1440x900";
                //  Configuration.browserSize = "1440x900";
                break;

            case "local_firefox":
                LOGGER.info("Starting local firefox browser");
                if (System.getProperty("webdriver.gecko.driver") == null) {
                    System.setProperty("webdriver.gecko.driver", Prop.getProp(PropKey.WEBDRIVER_GECKO_DRIVER));
                }
                Configuration.browser = "marionette";
                break;

            case "remote_chrome":
                LOGGER.info("Starting remote chrome browser");
                Configuration.browser = "by.issoft.info.wd.ChromeRemoteWebDriverProvider";
                break;

            case "remote_firefox":
                LOGGER.info("Starting remote firefox browser");
                Configuration.browser = "by.issoft.info.wd.FirefoxRemoteWebDriverProvider";
                break;

            default:
                throw new AutotestConfigException("'" + browser + "' browser does not support");
        }
    }
}
