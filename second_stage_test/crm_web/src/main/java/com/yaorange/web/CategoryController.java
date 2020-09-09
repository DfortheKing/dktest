package com.yaorange.web;

import com.yaorange.entity.Category;
import com.yaorange.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Resource(name = "categoryService")
    private CategoryService categoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Category> getCategorys(){
        List<Category> categories = categoryService.getCategoryList();
        return categories;
    }
}
