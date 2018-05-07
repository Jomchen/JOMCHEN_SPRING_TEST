package com.jomchen.springtest.test;


import com.jomchen.springtest.entity.basedata.Customer;
import com.jomchen.springtest.interfaces.basedata.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by Jomchen on 2018/1/5
 */
public class AllTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setAge(2);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-core.xml");
        CustomerService customerService = (CustomerService)context.getBean("customerService");
        customerService.printLogForCustomer(customer);
    }
}
