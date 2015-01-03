/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.ProductDAO;
import com.onlinemart.model.Product;
import com.onlinemart.model.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Keshav
 */
@Repository
public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO  {
    
    
    public ProductDAOImpl(Class<Product> entityClass) {
        super(entityClass);
    }

    public ProductDAOImpl() {
    }
 
    @Override
    public void saveProduct(Product product) {
        getSession().merge(product);
    }

    @Override
    public List<Product> listProducts() {
        return getSession().createCriteria(Product.class).list();
    }

    @Override
    public Product getProduct(int id) {
        return (Product) getSession().get(Product.class, id);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = getProduct(id);

        if (product != null) {
            getSession().delete(product);
        }
    }

 

    
}
