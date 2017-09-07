package by.issoft.info.config;

import static com.codeborne.selenide.Configuration.baseUrl;

import by.issoft.info.wd.WdConfig;

public class Configurator {
    public static void configure() {
        Prop.readProperties();

        /* selenide config */
        baseUrl = Prop.getProp(PropKey.SELENIDE_BASE_URL);

        /* WebDriver config*/
        WdConfig.configure();
    }
}
