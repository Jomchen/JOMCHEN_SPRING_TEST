package com.jomchen.springtest.interfaces.basedata.impl;

import com.jomchen.springtest.entity.basedata.Customer;
import com.jomchen.springtest.interfaces.basedata.CustomerInterface;

/**
 * create by Jomchen on 2018/1/5
 */
public class CustomerInterfaceImpl implements CustomerInterface {

    @Override
    public void printLogForCustomer(Customer customer) {
        System.out.println(customer.toString());
    }

}
