package com.jomchen.springtest.interfaces.basedata.impl;

import com.jomchen.springtest.entity.basedata.Customer;
import com.jomchen.springtest.interfaces.basedata.CustomerService;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * create by Jomchen on 2018/1/5
 */
@Component
public class CustomerServiceImpl implements CustomerService {

    private static Customer staticCustomer = new Customer(100, 100, "静态之王", "闲静的地方", new Date());
    private Properties properties;
    private Customer customer;
    private Map<String, String> map;
    private List<String> list;
    private Set<String> set;

    public CustomerServiceImpl() {}

    public CustomerServiceImpl(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void printLogForCustomer(Customer customer) {
        System.out.println(customer.toString());
    }

    public static Customer getStaticCustomer() { return staticCustomer; }
    public static void setStaticCustomer(Customer staticCustomer) { CustomerServiceImpl.staticCustomer = staticCustomer; }
    public Properties getProperties() { return properties; }
    public void setProperties(Properties properties) { this.properties = properties; }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<String> getList() { return list; }
    public void setList(List<String> list) { this.list = list; }
    public Set<String> getSet() { return set; }
    public void setSet(Set<String> set) { this.set = set; }
    public Map<String, String> getMap() { return map; }
    public void setMap(Map<String, String> map) { this.map = map; }

}
