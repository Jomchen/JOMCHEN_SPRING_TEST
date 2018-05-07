package com.jomchen.springtest.commons.enums;

import java.util.EnumSet;

/**
 * create by Jomchen on 5/6/18
 */
public enum ColorEnum {
    
    UNKOWN(-1, "unkown"),
    BLACK(0, "black"),
    WHITE(1, "white"),
    RED(2, "red"),
    GREEN(3, "green"),
    BLUE(4, "blue"),
    
    ;

    private int code;
    private String name;

    ColorEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
    public ColorEnum getColorEnumByCode(int i) {
        EnumSet<ColorEnum> colorEnumEnumSet = EnumSet.allOf(ColorEnum.class);
        ColorEnum result = null;
        for (ColorEnum c : colorEnumEnumSet) {
            if (c.getCode() == i) {
                result = c;
                break;
            }
        }
        return result;
    }
    
}
