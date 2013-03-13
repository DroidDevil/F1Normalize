package com.droiddevil.f1normalize.normalizer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class AbstractNormalizerProcessor<T> implements NormalizerProcessor {

    @Override
    public void normalize(Object object, boolean dryRun) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Class<? extends Annotation> annotationClass = getAnnotationClass();

        for (Field field : fields) {
            if (field.isAnnotationPresent(annotationClass)) {
                try {
                    if (field.getType().isAssignableFrom(getDataClass())) {
                        field.setAccessible(true);
                        Object oldData = field.get(object);
                        T data = getNormalizedData((T) oldData);
                        if (!dryRun) {
                            field.set(object, data);
                        }
                        if ((oldData != null || data != null) && oldData != null
                                && !oldData.equals(data)) {
                            System.out.println("Value changed: old[" + oldData + "] new[" + data
                                    + "]");
                        }
                    } else {
                        System.err.println("Type did not match for: " + getDataClass());
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected abstract Class<? extends Annotation> getAnnotationClass();

    protected abstract Class<T> getDataClass();

    protected abstract T getNormalizedData(T object);

}
