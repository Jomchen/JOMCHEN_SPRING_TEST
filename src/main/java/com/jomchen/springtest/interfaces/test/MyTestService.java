package com.jomchen.springtest.interfaces.test;

import com.jomchen.springtest.entity.test.MyTest;

/**
 * create by Jomchen on 6/16/18
 */
public interface MyTestService {

    /**
     * 添加
     * @return
     */
    MyTest add(int mid);

    /**
     * 删除
     * @return
     */
    MyTest delete(int mid);

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

}
