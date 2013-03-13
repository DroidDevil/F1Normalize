package com.droiddevil.f1normalize;

import java.util.Properties;
import java.util.Set;

import com.droiddevil.f1normalize.loader.F1LoaderPeople;
import com.droiddevil.f1normalize.model.Person;
import com.droiddevil.f1normalize.network.NetworkExecutor;
import com.droiddevil.f1normalize.normalizer.NormalizerEngine;
import com.droiddevil.f1normalize.util.PropertyLoader;

public class App {
    /**
     * The default property file name
     */
    private static final String PROPS_FILENAME = "config";

    private static final String PROPS_PROCESSORS = "processors";

    public static void main(String[] args) {
        PropertyLoader propertyLoader = new PropertyLoader();
        Properties properties = propertyLoader.getProperties(PROPS_FILENAME);
        F1NProtocol protocol = new F1NProtocol(properties);

        F1LoaderPeople loader = new F1LoaderPeople(protocol);
        // F1LoaderHousehold loader = new F1LoaderHousehold(protocol);
        loader.load();

        Set<Person> data = loader.getData();
        // Set<Household> data = loader.getData();

        Properties processors = propertyLoader.getProperties(PROPS_PROCESSORS);
        NormalizerEngine normalizer = new NormalizerEngine(processors);
        normalizer.normalize(data);

        NetworkExecutor.shutdown();

        return;
    }
}
