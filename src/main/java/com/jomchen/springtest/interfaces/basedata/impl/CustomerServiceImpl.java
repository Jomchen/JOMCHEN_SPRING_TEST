package com.jomchen.springtest.interfaces.basedata.impl;

import com.jomchen.springtest.entity.basedata.Customer;
import com.jomchen.springtest.interfaces.basedata.CustomerService;

import java.util.Date;

/**
 * create by Jomchen on 2018/1/5
 */
public class CustomerServiceImpl implements CustomerService {

    private static Customer staticCustomer = new Customer(1, 20, "Jomchen", "北京", new Date());
    private Customer customer;

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void printLogForCustomer(Customer customer) {
        System.out.println(customer.toString());
    }

    public static Customer getStaticCustomer() {
        return staticCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
