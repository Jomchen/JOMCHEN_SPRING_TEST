package com.jomchen.springtest.utils;

import com.jomchen.springtest.commons.enums.ErrorMessageEnum;
import com.jomchen.springtest.commons.exceptions.ErrorMessage;

import java.lang.reflect.Field;

/**
 * create by Jomchen on 2018/5/29
 */
public class DateTimeUtils {

    public <T, K>K changeTToK(T source, K target) throws NoSuchFieldException, IllegalAccessException {
        if (source == null) { throw new ErrorMessage(ErrorMessageEnum.ERROR_01); }
        if (target == null) { throw new ErrorMessage(ErrorMessageEnum.ERROR_02); }

        Class<?> tc = source.getClass();
        Class<?> kc = target.getClass();

        Field[] fields = tc.getDeclaredFields();
        if (null == fields || fields.length <= 0) return target;

        for (int i = 0; i < fields.length; i ++) {
            Field field = fields[i];
            String fieldName = field.getName();
            boolean confirmAccessibleTc = field.isAccessible();

            Field fieldKc = kc.getDeclaredField(fieldName);
            boolean confirmAccessibleKc = fieldKc.isAccessible();
            if (null != fieldKc) {
                Object value = field.get(source);
                fieldKc.set(target, value);

                field.setAccessible(confirmAccessibleTc);
                fieldKc.setAccessible(confirmAccessibleKc);
            }
        }

        return target;
    }
}
