package com.jomchen.springtest.commons.exceptions;

import com.jomchen.springtest.commons.enums.ErrorMessageEnum;

/**
 * create by Jomchen on 5/6/18
 */
public class BizException extends RuntimeException {

    private int code;
    private String message;

    public BizException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(ErrorMessageEnum error) {
        super(error.getName());
        this.code = error.getCode();
        this.message = error.getName();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
