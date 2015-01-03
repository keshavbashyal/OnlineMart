/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.ShoppingCart;
import com.onlinemart.model.Vendor;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keshav
 */
@Service
public interface ShoppingCartService {
    
    public void saveShoppingCart(ShoppingCart shoppingCart);
    public List<ShoppingCart> listShoppingCart();
    public ShoppingCart getShoppingCart(int id);
    public void deleteShoppingCart(int id);

    
}
