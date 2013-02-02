package com.droiddevil.f1normalize.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class used to load properties.
 * 
 * @author tperrien
 * 
 */
public class PropertyLoader {

    /**
     * A map of config file names and their associated properties.
     */
    private Map<String, Properties> mPropMap = new HashMap<String, Properties>();

    /**
     * Get a property for the specified config file name.
     * 
     * @param filename
     *            The {@link Properties} file to retrieve.
     * @return The file backed properties or null if it cannot be loaded.
     */
    public Properties getProperties(String filename) {
        Properties properties = mPropMap.get(filename);
        if (properties == null) {
            InputStream stream = getClass().getClassLoader()
                    .getResourceAsStream(filename);
            try {
                properties = new Properties();
                properties.load(stream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                    }
                }
            }

            mPropMap.put(filename, properties);
        }

        return properties;
    }

}
