package utilities;

import java.util.Properties;

public class ConfigProperties {
    Properties configFile = new Properties();

    public void setProperties() {
        try {
            configFile.load(this.getClass().getClassLoader().getResourceAsStream("base.properties"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getProperties(String key) {

        setProperties();
        if (System.getProperty(key) != null)
            return System.getProperty(key);
        else
            return configFile.getProperty(key);
    }
}
