package com.yaorange.service.impl;

import com.yaorange.dao.ProductDao;
import com.yaorange.entity.Products;
import com.yaorange.service.ProductService;
import com.yaorange.utils.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource(name = "productDao")
    private ProductDao productDao;

    @Override
    public Pagination getPage(Integer current, Integer pageSize) {
        Pagination page = productDao.getPage("from Products", current, pageSize);
        return page;
    }

    @Override
    public void addProduct(Products products) {
        productDao.add(products);
    }

    @Override
    public void deleteProduct(Products products) {
        productDao.update(products);
    }

    @Override
    public Products getOneById(Integer id) {
        Products products = productDao.get(id);
        return products;
    }


}
