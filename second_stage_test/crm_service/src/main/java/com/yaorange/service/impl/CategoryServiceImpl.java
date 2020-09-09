package com.yaorange.service.impl;

import com.yaorange.dao.CategoryDao;
import com.yaorange.entity.Category;
import com.yaorange.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    @Override
    public List<Category> getCategoryList() {
        List<Category> list = categoryDao.getList("from Category");
        return list;
    }
}
