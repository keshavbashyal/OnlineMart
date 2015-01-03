package com.onlinemart.dao.impl;

import com.onlinemart.dao.ProductDAO;
import com.onlinemart.model.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Keshav
 */
@Repository
public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO{
     public ProductDAOImpl(Class<Product> entityClass) {
        super(entityClass);
    }
    
    public ProductDAOImpl() {
        super();
    }
    
    
            
    public void saveProduct(Product category)
    {
        getSession().merge(category);
    }

    public List<Product> listProduct()
    {
        return getSession().createCriteria(Product.class).list();
    }

    public Product getProduct(Long id)
    {
        return (Product) getSession().get(Product.class, id);
    }

    public void deleteProduct(Long id)
    {
        Product category = getProduct(id);
        if(category != null)
            getSession().delete(category);
    }
    
    
}
