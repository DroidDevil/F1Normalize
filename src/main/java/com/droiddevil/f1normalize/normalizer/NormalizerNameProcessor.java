package com.droiddevil.f1normalize.normalizer;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.text.WordUtils;

public class NormalizerNameProcessor extends AbstractNormalizerProcessor<String> {

    @Override
    protected Class<? extends Annotation> getAnnotationClass() {
        return NormalizerName.class;
    }

    @Override
    protected Class<String> getDataClass() {
        return String.class;
    }

    @Override
    protected String getNormalizedData(String object) {
        String value = object;

        if (object != null) {
            value = WordUtils.capitalize(object.toLowerCase(), '\'');
        }

        return value;
    }
}
