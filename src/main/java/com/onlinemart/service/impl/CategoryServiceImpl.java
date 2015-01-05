/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.CategoryDAO;
import com.onlinemart.model.Category;
import com.onlinemart.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sBam
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
     @Autowired
    private CategoryDAO categoryDao;
    
    @Transactional
    public void saveCategory(Category category)
    {
        categoryDao.saveCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Category> listCategory()
    {
        return categoryDao.listCategory();
    }

    @Transactional(readOnly = true)
    public Category getCategory(Long id)
    {
        return categoryDao.getCategory(id);
    }

    @Transactional
    public void deleteCategory(Long id)
    {
        categoryDao.deleteCategory(id);
    }
    
}
