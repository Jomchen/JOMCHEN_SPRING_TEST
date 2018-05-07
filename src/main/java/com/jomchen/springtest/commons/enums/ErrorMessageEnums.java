package com.jomchen.springtest.commons.enums;

/**
 * create by Jomchen on 5/6/18
 */
public enum ErrorMessageEnums {

    ERROR(-1, "未知错误"),
    ERROR_00(0, "系统错误"),

    ;


    private int code;
    private String name;

    public ErrorMessageEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
