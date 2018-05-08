package com.jomchen.springtest.commons.enums;

import java.util.EnumSet;

/**
 * create by Jomchen on 5/6/18
 */
public enum ErrorMessageEnum {

    ERROR(-1, "未知错误"),
    ERROR_00(0, "系统错误"),

    ;


    private int code;
    private String name;

    ErrorMessageEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public ErrorMessageEnum getErrorMessageEnum(int code) {
        EnumSet<ErrorMessageEnum> errorMessageEnumEnumSet = EnumSet.allOf(ErrorMessageEnum.class);
        for (ErrorMessageEnum e : errorMessageEnumEnumSet) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
