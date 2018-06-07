package com.jomchen.springtest.entity.business;

import com.jomchen.springtest.entity.common.BaseEntity;

import java.util.Objects;

/**
 * create by Jomchen on 2018/6/7
 */
public class Product extends BaseEntity {

    private Integer pid;

    /**
     * 商品名字
     */
    private String pname;

    /**
     * 商品价格
     */
    private long price;

    public Product() {
    }

    public Product(Integer pid, String pname, long price) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(pid, product.pid) &&
                Objects.equals(pname, product.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, pname, price);
    }

}
