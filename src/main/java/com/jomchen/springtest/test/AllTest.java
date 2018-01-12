package com.jomchen.springtest.test;


import java.util.ArrayList;
import java.util.List;

/**
 * create by Jomchen on 2018/1/5
 */
public class AllTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("2");
        list.add("1");
        list.add("0");
        list.stream().forEach(System.out::println);
    }
}
