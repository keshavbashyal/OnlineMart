/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.ShoppingCart;
import java.util.List;

/**
 *
 * @author Keshav
 */

public interface ShoppingCartDAO {
    
    public void saveShoppingCart(ShoppingCart shoppingCart); // create and update
	public List<ShoppingCart> listShoppingCarts();
	public ShoppingCart getShoppingCart(int id);
	public void deleteShoppingCart(int id);
    
}
