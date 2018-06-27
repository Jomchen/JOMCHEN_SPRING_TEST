package com.jomchen.springtest.controllers.test;

import com.jomchen.springtest.commons.web.UrlContents;
import com.jomchen.springtest.interfaces.test.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by Jomchen on 6/16/18
 */
@Controller
public class MyTestController {

    @Autowired
    private MyTestService myTestService;

    /**
     * 查询
     * @return
     */
    @ResponseBody
    @RequestMapping(UrlContents.MYTEST_GET)
    public String get(int mid) {
        myTestService.get(mid);
        return null;
    }

    /**
     * 增加
     * @return
     */
    @ResponseBody
    @RequestMapping(UrlContents.MYTEST_ADD)
    public String add(int mid) {
        myTestService.add(mid);
        return null;
    }

    /**
     * 修改
     * @return
     */
    @ResponseBody
    @RequestMapping(UrlContents.MYTEST_UPDATE)
    public String update() {
        myTestService.update();
        return null;
    }

    /**
     * 删除
     * @return
     */
    @ResponseBody
    @RequestMapping(UrlContents.MYTEST_DELETE)
    public String delete(int mid) {
        myTestService.delete(mid);
        return null;
    }

    /**
     * 条件删除
     * @return
     */
    @ResponseBody
    @RequestMapping(UrlContents.MYTEST_DELETE_BY_MID)
    public String deleteByMid(int mid, int age) {
        myTestService.deleteByMid(mid, age);
        return null;
    }

}
