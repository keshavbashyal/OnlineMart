/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.Product;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keshav
 */

@Service
public interface ProductService {

    public void saveProduct(Product product);
    public List<Product> listProducts();
    public Product getProduct(Long id);
    public void deleteProduct(Long id);

}
