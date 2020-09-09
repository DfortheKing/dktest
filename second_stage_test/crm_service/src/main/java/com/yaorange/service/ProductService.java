package com.yaorange.service;

import com.yaorange.entity.Products;
import com.yaorange.utils.Pagination;

public interface ProductService {
    Pagination getPage(Integer current, Integer pageSize);

    void addProduct(Products products);

    void deleteProduct(Products products);

    Products getOneById(Integer id);
}
