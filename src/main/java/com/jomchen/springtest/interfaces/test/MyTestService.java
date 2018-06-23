package com.jomchen.springtest.interfaces.test;

import com.jomchen.springtest.entity.test.MyTest;

/**
 * create by Jomchen on 6/16/18
 */
public interface MyTestService<T> {

    /**
     * 添加
     * @return
     */
    MyTest add(int mid);

    /**
     * 删除
     * @return
     */
    void delete(int mid);

    /**
     * 更新
     * @return
     */
    MyTest update();

    /**
     * 查询
     * @param mid
     * @return
     */
    MyTest get(int mid);

    /**
     * 条件删除
     * @return
     */
    MyTest deleteByMid(int mid, int age);


    /**
     * 其它方法操作
     * @return
     */
    int otherOperator(String cname, int age);

    int otherOperator2(int age, String cname);

}
