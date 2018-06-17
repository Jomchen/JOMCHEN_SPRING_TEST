package com.jomchen.springtest.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * create by Jomchen on 6/17/18
 */
@Component
@PropertySource("classpath:/message-develope.properties")
public class PropertiesUtils {

    /**
     * 名字
     */
    @Value("${develop.com.jomchen.name}")
    private String name;
    /**
     * 等级
     */
    @Value("${develop.com.jomchen:9999}")
    private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PropertiesUtils{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

}
