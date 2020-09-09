package com.yaorange.dao.impl;

import com.yaorange.dao.CategoryDao;
import com.yaorange.entity.Category;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category,Integer> implements CategoryDao {
}
