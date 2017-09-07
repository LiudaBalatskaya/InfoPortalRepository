package by.issoft.info.config;

import by.issoft.info.tests.CINFP350HeaderComposition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.properties.PropertyLoader;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Prop {
    private final static Logger LOGGER = LoggerFactory.getLogger(CINFP350HeaderComposition.class);
    private static final String TEST_PROPERTIES = "/test.properties";
    private static final Properties props = new Properties();


    public static void readProperties() {
        try {
            props.load(PropertyLoader.class.getResourceAsStream(TEST_PROPERTIES));
        } catch (IOException e) {
            throw new AutotestConfigException(TEST_PROPERTIES + " file cannot be read. Details: " + e.getMessage(), e);
        }
        Set<String> setOfProps = props.stringPropertyNames();
        for (String item : setOfProps) {
            if (System.getProperty(item) != null) {
                LOGGER.info(String.format("'%s' value (it is got from System Property) is set instead of '%s' value of '%s' property",
                        System.getProperty(item), props.getProperty(item), item));
                props.replace(item, System.getProperty(item));
            } else {
                LOGGER.info(String.format("%s=%s", item, props.getProperty(item)));
            }
        }
    }


    public static String getProp(String key) {
        if (props.containsKey(key)) {
            return props.getProperty(key);
        }
        throw new AutotestConfigException(String.format("'%s' property is absent", key));
    }
}
