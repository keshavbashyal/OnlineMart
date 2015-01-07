/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.ProductShoppingCart;
import com.onlinemart.model.Sales;
import java.util.List;

/**
 *
 * @author acer
 */

public interface ProductShoppingCartDAO {
    
    public void saveProductShoppingCart(ProductShoppingCart productShoppingCart); // create and update
    public List<ProductShoppingCart> listProductShoppingCarts();
    public ProductShoppingCart getProductShoppingCart(Long id);
    public void deleteProductShoppingCart(Long id);
  
}