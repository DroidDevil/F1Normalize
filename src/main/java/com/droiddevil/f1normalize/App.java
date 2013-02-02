package com.droiddevil.f1normalize;

import java.util.Properties;

import com.droiddevil.f1normalize.util.PropertyLoader;

public class App {
    /**
     * The default property file name
     */
    private static final String PROPS_FILENAME = "config";

    public static void main(String[] args) {
        PropertyLoader propertyLoader = new PropertyLoader();
        Properties properties = propertyLoader.getProperties(PROPS_FILENAME);
        F1NProtocol protocol = new F1NProtocol(properties);

        F1LoaderHousehold loader = new F1LoaderHousehold();
        loader.load(protocol);

        return;
    }

}
