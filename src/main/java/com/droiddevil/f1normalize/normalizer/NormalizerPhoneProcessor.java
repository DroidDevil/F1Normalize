package com.droiddevil.f1normalize.normalizer;

import java.lang.annotation.Annotation;

public class NormalizerPhoneProcessor extends AbstractNormalizerProcessor<String> {

    @Override
    protected Class<? extends Annotation> getAnnotationClass() {
        return NormalizerPhone.class;
    }

    @Override
    protected Class<String> getDataClass() {
        return String.class;
    }

    @Override
    protected String getNormalizedData(String object) {
        String value = object;

        if (object != null) {
            String digits = object.replaceAll("\\D+", "");

            if (digits.length() == 7) {
                value = digits.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
            } else if (digits.length() == 10) {
                value = digits.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
            } else if (digits.length() == 11) {
                digits = digits.substring(1);
                value = digits.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
            }
        }

        return value;
    }
}
