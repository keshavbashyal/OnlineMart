/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.ProductShoppingCartDAO;
import com.onlinemart.model.Product;
import com.onlinemart.model.ProductShoppingCart;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author acer
 */
@Repository
public class ProductShoppingCartDAOImpl extends AbstractDAO<ProductShoppingCart> implements ProductShoppingCartDAO{

    public ProductShoppingCartDAOImpl(Class<ProductShoppingCart> entityClass) {
        super(entityClass);
    }

    public ProductShoppingCartDAOImpl() {
    }
    @Override
    public void saveProductShoppingCart(ProductShoppingCart productShoppingCart) {
       getSession().merge(productShoppingCart);
    }

    @Override
    public List<ProductShoppingCart> listProductShoppingCarts() {
        return getSession().createCriteria(ProductShoppingCart.class).list();
    }

    @Override
    public ProductShoppingCart getProductShoppingCart(Long id) {
        return (ProductShoppingCart)getSession().get(ProductShoppingCart.class,id);
    }

    @Override
    public void deleteProductShoppingCart(Long id) {
       getSession().delete(getProductShoppingCart(id));
    }
    
}
