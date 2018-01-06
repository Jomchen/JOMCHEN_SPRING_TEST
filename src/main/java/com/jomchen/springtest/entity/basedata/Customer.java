package com.jomchen.springtest.entity.basedata;

import com.jomchen.springtest.entity.common.BaseEntity;

import java.util.Date;
import java.util.Objects;

/**
 * create by Jomchen on 2018/1/5
 */
public class Customer extends BaseEntity {

    private Integer cid;
    private String cname;
    private Integer age;
    private Date birthday;

    public Customer() {
    }

    public Customer(Integer cid, String cname, Integer age, Date birthday) {
        this.cid = cid;
        this.cname = cname;
        this.age = age;
        this.birthday = birthday;
    }

    public Integer getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cid, customer.cid) &&
                Objects.equals(cname, customer.cname) &&
                Objects.equals(age, customer.age) &&
                Objects.equals(birthday, customer.birthday);
    }

}
