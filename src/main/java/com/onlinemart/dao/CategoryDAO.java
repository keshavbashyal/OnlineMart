/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.Category;
import java.util.List;

/**
 *
 * @author sBam
 */
public interface CategoryDAO {
    public void saveCategory(Category category);
    public List<Category> listCategory();
    public Category getCategory(Long id);
    public void deleteCategory(Long id);
    
}
