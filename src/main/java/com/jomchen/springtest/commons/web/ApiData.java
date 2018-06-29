package com.jomchen.springtest.commons.web;

import com.jomchen.springtest.commons.enums.ErrorMessageEnum;

/**
 * create by Jomchen on 2018/6/29
 * 用于接口反馈信息
 */
public class ApiData<T> {

    private int code;
    private String message;
    private T data;

    public ApiData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiData(ErrorMessageEnum errorMessageEnum, T data) {
        this.code = errorMessageEnum.getCode();
        this.message = errorMessageEnum.getName();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
