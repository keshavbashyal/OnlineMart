/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.Product;
import java.util.List;

/**
 *
 * @author Keshav
 */

public interface ProductDAO {
    
    public void saveProduct(Product product);
    public List<Product> listProduct();
    public Product getProduct(Long id);
    public void deleteProduct(Long id);
}
