package com.jomchen.springtest.commons.factorys;

import com.jomchen.springtest.entity.basedata.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by Jomchen on 2018/5/29
 */
@Configuration
public class OneFactory {


    @Bean
    public Customer factoryCustomer() {
        Customer bean = new Customer();
        bean.setCid(0);
        bean.setCname("测试用户");
        bean.setAddress("测试用户地址");
        return bean;
    }

}
