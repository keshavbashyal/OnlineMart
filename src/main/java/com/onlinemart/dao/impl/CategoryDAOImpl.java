/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.CategoryDAO;
import com.onlinemart.model.Category;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sBam
 */
@Repository
public class CategoryDAOImpl extends AbstractDAO<Category> implements CategoryDAO {
    public CategoryDAOImpl(Class<Category> entityClass) {
        super(entityClass);
    }
    
    public CategoryDAOImpl() {
        super();
    }
    
    
            
    public void saveCategory(Category category)
    {
        getSession().merge(category);
    }

    public List<Category> listCategory()
    {
        return getSession().createCriteria(Category.class).list();
    }
    
    public Category getCategory(Long id)
    {
        return (Category) getSession().get(Category.class, id);
    }

    public void deleteCategory(Long id)
    {
        Category category = getCategory(id);
        if(category != null)
            getSession().delete(category);
    }
}
