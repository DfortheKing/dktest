package com.yaorange.dao.impl;

import com.yaorange.dao.ProductDao;
import com.yaorange.entity.Products;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Products,Integer> implements ProductDao {
}
