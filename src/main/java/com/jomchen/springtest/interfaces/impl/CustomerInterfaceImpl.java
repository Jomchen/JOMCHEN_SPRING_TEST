package com.jomchen.springtest.interfaces.impl;

import com.jomchen.springtest.entity.Customer;
import com.jomchen.springtest.interfaces.CustomerInterface;

/**
 * create by Jomchen on 2018/1/5
 */
public class CustomerInterfaceImpl implements CustomerInterface {

    @Override
    public void printLogForCustomer(Customer customer) {
        System.out.println(customer.toString());
    }

}
