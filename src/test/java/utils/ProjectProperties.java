package utils;

import java.io.IOException;
import java.util.Properties;

public enum ProjectProperties {

    PORT("Port");

    private final String value;

    ProjectProperties(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static String getProperty(ProjectProperties property) {
        try {
            Properties props = new Properties();
            props.load(ProjectProperties.class.getClassLoader().getResourceAsStream("environment.properties"));
            return props.getProperty(property.getValue());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}