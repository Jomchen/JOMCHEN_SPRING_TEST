package com.jomchen.springtest.interfaces.test.impl;

import com.jomchen.springtest.annotations.TestAnnotation;
import com.jomchen.springtest.entity.test.MyTest;
import com.jomchen.springtest.interfaces.test.MyTestService;
import org.springframework.stereotype.Service;

/**
 * create by Jomchen on 6/16/18
 */
@Service("myTestServiceImpl")

public class MyTestServiceImpl implements MyTestService {

    @Override
    @TestAnnotation
    public MyTest add(int mid) {
        MyTest myTest = new MyTest(mid, "康康" + mid, 10 + mid, "北京" + mid, null, null);
        System.out.println("不管怎样，我执行了添加操作。。");
        System.out.println("不管怎样，我执行了添加操作。。");
        System.out.println("不管怎样，我执行了添加操作。。");
        return myTest;
    }

    @Override
    public void delete(int mid) {
        System.out.println("不管怎样，我执行了删除操作。。");
        System.out.println("不管怎样，我执行了删除操作。。");
        System.out.println("不管怎样，我执行了删除操作。。");
    }

    @Override
    public MyTest update() {
        System.out.println("不管怎样，我执行了更新操作。。");
        System.out.println("不管怎样，我执行了更新操作。。");
        System.out.println("不管怎样，我执行了更新操作。。");
        return null;
    }

    @Override
    public MyTest get(int mid) {
        System.out.println("不管怎样，我执行了获取方法。。");
        System.out.println("不管怎样，我执行了获取方法。。");
        System.out.println("不管怎样，我执行了获取方法。。");
        return null;
    }

    @Override
    public MyTest deleteByMid(int mid, int age) {
        System.out.println("不管怎样，我执行了条件删除。。");
        System.out.println("不管怎样，我执行了条件删除。。");
        System.out.println("不管怎样，我执行了条件删除。。");
        return null;
    }

    @Override
    public int otherOperator(String cname, int age) {
        System.out.println(cname + "我是执行了一些其它的操作。。");
        System.out.println(cname + "我是执行了一些其它的操作。。");
        System.out.println(cname + "我是执行了一些其它的操作。。");
        return 100;
    }

    @Override
    public int otherOperator2(int age, String name) {
        System.out.println("这个嘛");
        System.out.println("这个嘛");
        System.out.println("这个嘛");
        return 99;
    }

    public <T> Class<T> genericsTest(T t) {
        return (Class<T>) t.getClass();
    }

}
