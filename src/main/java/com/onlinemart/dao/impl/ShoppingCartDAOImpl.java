/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.ShoppingCartDAO;
import com.onlinemart.model.ShoppingCart;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Keshav
 */

@Repository
public class ShoppingCartDAOImpl extends AbstractDAO<ShoppingCart> implements ShoppingCartDAO{
    
    public ShoppingCartDAOImpl(Class<ShoppingCart> entityClass) {
        super(entityClass);
    }

    public ShoppingCartDAOImpl() {
    }
 
    @Override
    public void saveShoppingCart(ShoppingCart shoppingCart) {
        getSession().merge(shoppingCart);
    }

    @Override
    public List<ShoppingCart> listShoppingCarts() {
        return getSession().createCriteria(ShoppingCart.class).list();
    }

    public ShoppingCart getShoppingCart(int id) {
        return (ShoppingCart) getSession().get(ShoppingCart.class, id);
    }

    public void deleteShoppingCart(int id) {
        ShoppingCart shoppingCart = getShoppingCart(id);

        if (shoppingCart != null) {
            getSession().delete(shoppingCart);
        }
    }

    public ShoppingCart getShoppingCartById(int id) {
        return (ShoppingCart) getSession().get(ShoppingCart.class, id);
    }
 
    
}
