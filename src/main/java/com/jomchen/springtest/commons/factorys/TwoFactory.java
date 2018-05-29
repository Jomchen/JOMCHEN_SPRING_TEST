package com.jomchen.springtest.commons.factorys;

import com.jomchen.springtest.entity.basedata.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * create by Jomchen on 2018/5/29
 */
@Component
public class TwoFactory {

    @Autowired
    Customer customer;
}
