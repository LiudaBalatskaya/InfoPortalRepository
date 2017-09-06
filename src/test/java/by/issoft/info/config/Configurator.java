package by.issoft.info.config;

import static com.codeborne.selenide.Configuration.baseUrl;

import by.issoft.info.wd.WdConfig;
import org.apache.log4j.PropertyConfigurator;

public class Configurator {
    public static void configure() {
        Prop.readProperties();

        /* log4j config*/
        PropertyConfigurator.configure(Prop.getProp(PropKey.LOG4J_PROP_FILE));

        /* selenide config */
        baseUrl = Prop.getProp(PropKey.SELENIDE_BASE_URL);

        /* WebDriver config*/
        WdConfig.setUp();
    }
}
