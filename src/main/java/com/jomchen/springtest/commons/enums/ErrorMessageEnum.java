package com.jomchen.springtest.commons.enums;

import java.util.EnumSet;

/**
 * create by Jomchen on 5/6/18
 */
public enum ErrorMessageEnum {

    ERROR(-1, "未知错误"),
    ERROR_00(0, "请求成功"),
    ERROR_01(1, "系统错误"),
    ERROR_02(2, "对象源不能为空"),
    ERROR_03(3, "目标对象不能为空")

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
        EnumSet<ErrorMessageEnum> errorMessageEnums = EnumSet.allOf(ErrorMessageEnum.class);
        for (ErrorMessageEnum e : errorMessageEnums) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}
