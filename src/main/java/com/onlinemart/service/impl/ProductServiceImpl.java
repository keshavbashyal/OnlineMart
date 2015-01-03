/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.ProductDAO;
import com.onlinemart.model.Product;
import com.onlinemart.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    
    
    @Autowired
    ProductDAO productDao;

    @Transactional
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Transactional(readOnly = true)
    public List<Product> listProducts() {
        return productDao.listProduct();
    }

    @Transactional(readOnly = true)
    public Product getProduct(Long id) {
        return productDao.getProduct(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);

    }

     
}
