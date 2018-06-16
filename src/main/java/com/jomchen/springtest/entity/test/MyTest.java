package com.jomchen.springtest.entity.test;

import com.jomchen.springtest.entity.basedata.Customer;
import com.jomchen.springtest.entity.basedata.Kongfu;
import com.jomchen.springtest.entity.common.BaseEntity;

/**
 * create by Jomchen on 6/16/18
 */
public class MyTest extends BaseEntity {

    private int mid;
    private String name;
    private int age;
    private String address;
    private Kongfu kongfu;
    private Customer customer;

    public MyTest() {
    }

    public MyTest(int mid, String name, int age, String address, Kongfu kongfu, Customer customer) {
        this.mid = mid;
        this.name = name;
        this.age = age;
        this.address = address;
        this.kongfu = kongfu;
        this.customer = customer;
    }

    public int getMid() {
        return mid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Kongfu getKongfu() {
        return kongfu;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setKongfu(Kongfu kongfu) {
        this.kongfu = kongfu;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTest myTest = (MyTest) o;

        if (mid != myTest.mid) return false;
        if (age != myTest.age) return false;
        if (name != null ? !name.equals(myTest.name) : myTest.name != null) return false;
        if (address != null ? !address.equals(myTest.address) : myTest.address != null) return false;
        if (kongfu != null ? !kongfu.equals(myTest.kongfu) : myTest.kongfu != null) return false;
        return customer != null ? customer.equals(myTest.customer) : myTest.customer == null;
    }

    @Override
    public int hashCode() {
        int result = mid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (kongfu != null ? kongfu.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }

}
