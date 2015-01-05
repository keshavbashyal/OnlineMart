/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.Category;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sBam
 */
@Service
public interface CategoryService {
     public void saveCategory(Category category);
    public List<Category> listCategory();
    public Category getCategory(Long id);
    public void deleteCategory(Long id);
}
