package com.myself.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @program: mybatisTest
 * @author: 吴小龙
 * @create: 2019-10-12 13:24
 * @description: 这是一个商品类别类，包含类别id和类别name
 */

public class Category implements Serializable {
    private int id;
    private String name;
    List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
