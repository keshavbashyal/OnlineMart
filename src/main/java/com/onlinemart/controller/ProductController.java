/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.Product;
import com.onlinemart.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Keshav
 */
@Controller
public class ProductController {
    
    
    @Autowired
    ProductService productService;
 
    @RequestMapping(value = "vendor/product/save", method = RequestMethod.POST)
    public String saveUser(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "vendor/productform";
        } else {
            productService.saveProduct(product);
        }
        return "redirect:/vendor/productlist";
    }

    @RequestMapping(value = "/vendor/productlist")
    public String listUsers(Model model) {
        model.addAttribute("products", productService.listProducts());
        return "vendor/productlist";
    }

    @RequestMapping("vendor/product/edit/{productid}")
    public String editUser(@PathVariable("productid") Long id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "vendor/productform";
    }

    @RequestMapping("vendor/product/delete/{productid}")
    public String deleteUser(@PathVariable("productid") Long id, Model model) {
        productService.deleteProduct(id);
        return "redirect:/vendor/productlist";
    }
    
    
    @RequestMapping("/vendor/productform")
    public String vendorProductForm(Product product) {
        return "/vendor/productform";
    }
    
    @RequestMapping("/product/productlist")
    public String productList(Product product) {
        return "/product/productlist";
    }
     
    
    
}
