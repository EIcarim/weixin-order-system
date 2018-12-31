package com.hmtech.utils;


import com.hmtech.enums.StatusEnum;

public class EnumUtil {

    public static <T extends StatusEnum> T getByStatus(Integer status, Class<T> enumClass) {
        for (T t : enumClass.getEnumConstants()) {
            if (status.equals(t.getStatus())) {
                return t;
            }
        }
        return null;
    }
}
