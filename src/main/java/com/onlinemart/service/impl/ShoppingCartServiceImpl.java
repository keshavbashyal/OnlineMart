/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.ShoppingCartDAO;
import com.onlinemart.model.ShoppingCart;
import com.onlinemart.service.ShoppingCartService;
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
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    ShoppingCartDAO shoppingCartDao;
    
    @Override
    public void saveShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDao.saveShoppingCart(shoppingCart);
    }

    @Transactional(readOnly = true)
    public List<ShoppingCart> listShoppingCart() {
       return shoppingCartDao.listShoppingCarts();
    }

    @Transactional(readOnly = true)
    public ShoppingCart getShoppingCart(int id) {
         return shoppingCartDao.getShoppingCart(id);
    }

    @Override
    public void deleteShoppingCart(int id) {
     shoppingCartDao.deleteShoppingCart(id);   
    }

    
    
}
