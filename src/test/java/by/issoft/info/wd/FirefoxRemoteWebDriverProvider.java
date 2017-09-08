package by.issoft.info.wd;

import by.issoft.info.config.Prop;
import by.issoft.info.config.PropKey;
import by.issoft.info.exceptions.AutotestConfigException;
import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxRemoteWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        URL url;
        try {
            url = new URL(Prop.getProp(PropKey.WEBDRIVER_FIREFOX_REMOTE_HUB));
        } catch (MalformedURLException e) {
            throw new AutotestConfigException("Value of " + PropKey.WEBDRIVER_FIREFOX_REMOTE_HUB + " property is wrong. " +
                    "Details: " + e.getMessage(), e);
        }
        capabilities = DesiredCapabilities.firefox();
        RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);
        return driver;
    }
}
