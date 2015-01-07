/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.ProductShoppingCartDAO;
import com.onlinemart.model.ProductShoppingCart;
import com.onlinemart.service.ProductShoppingCartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author acer
 */
@Service
@Transactional
public class ProductShoppingCartServiceImpl implements ProductShoppingCartService {

    @Autowired
    ProductShoppingCartDAO productShoppingCartDAO;
    @Override
    public void saveProductShoppingCart(ProductShoppingCart productShoppingCart) {
        productShoppingCartDAO.saveProductShoppingCart(productShoppingCart);
    }

    @Override
    public List<ProductShoppingCart> listProductShoppingCarts() {
        return productShoppingCartDAO.listProductShoppingCarts();
    }

    @Override
    public ProductShoppingCart getProductShoppingCart(Long id) {
        return productShoppingCartDAO.getProductShoppingCart(id);
    }

    @Override
    public void deleteProductShoppingCart(Long id) {
        productShoppingCartDAO.deleteProductShoppingCart(id);
    }
    
}
