package by.issoft.info.config;

import by.issoft.info.wd.WdConfig;
import org.apache.log4j.PropertyConfigurator;

public class Configurator {
    public static void setUp() {
        PropertyConfigurator.configure(".\\src\\test\\resources\\log4j.properties");
        WdConfig.setUp();
    }


    public static void tearDownUp() {

    }
}
