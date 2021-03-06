package com.jomchen.springtest.entity.basedata;

import com.jomchen.springtest.entity.BaseEntity;

import java.util.Date;

/**
 * create by Jomchen on 2018/1/5
 */
public class Customer extends BaseEntity {

    private Integer cid;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 姓名
     */
    private String cname;
    /**
     * 地址
     */
    private String address;
    /**
     * 生日
     */
    private Date birthday;

    public Customer() {
    }

    public Customer(Integer cid, Integer age, String cname, String address, Date birthday) {
        this.cid = cid;
        this.age = age;
        this.cname = cname;
        this.address = address;
        this.birthday = birthday;
    }

    public Integer getCid() {
        return cid;
    }

    public Integer getAge() {
        return age;
    }

    public String getCname() {
        return cname;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (cid != null ? !cid.equals(customer.cid) : customer.cid != null) return false;
        if (age != null ? !age.equals(customer.age) : customer.age != null) return false;
        if (cname != null ? !cname.equals(customer.cname) : customer.cname != null) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        return birthday != null ? birthday.equals(customer.birthday) : customer.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", age=" + age +
                ", cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }

}
