package com.droiddevil.f1normalize.normalizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class NormalizerEngine {

    private Properties mProperties;

    private Map<String, NormalizerProcessor> mProcessors = new HashMap<String, NormalizerProcessor>();

    public NormalizerEngine(Properties properties) {
        mProperties = properties;
        loadProcessors();
    }

    private void loadProcessors() {
        for (Object obj : mProperties.keySet()) {
            String key = (String) obj;
            String className = mProperties.getProperty(key);
            NormalizerProcessor processor = null;
            try {
                processor = (NormalizerProcessor) Class.forName(className).newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ClassCastException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                // Class could be an interface, abstract, etc
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // Class or constructor not accessible
                e.printStackTrace();
            } catch (Exception e) {
                // Catch everything else
                e.printStackTrace();
            }

            if (processor != null) {
                mProcessors.put(key, processor);
            }
        }
    }

    public void normalize(Collection<?> data) {
        for (Object obj : data) {
            for (String key : mProcessors.keySet()) {
                NormalizerProcessor processor = mProcessors.get(key);
                processor.normalize(obj, true);
            }
        }
    }
}
