package by.issoft.info.wd;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeRemoteWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        URL url = null;
        try {
            url = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        capabilities = DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);
        return driver;
    }
}
