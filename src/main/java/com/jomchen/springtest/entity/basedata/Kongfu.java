package com.jomchen.springtest.entity.basedata;

import com.jomchen.springtest.entity.common.BaseEntity;

/**
 * create by Jomchen on 5/20/18
 * 功夫
 */
public class Kongfu extends BaseEntity {

    private Integer kid;
    /**
     * 名字
     */
    private String name;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 创始人
     */
    private Customer founder;

    public Kongfu() {
    }

    public Kongfu(Integer kid, String name, Integer level, Customer founder) {
        this.kid = kid;
        this.name = name;
        this.level = level;
        this.founder = founder;
    }

    public Integer getKid() {
        return kid;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Customer getFounder() {
        return founder;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setFounder(Customer founder) {
        this.founder = founder;
    }

}
