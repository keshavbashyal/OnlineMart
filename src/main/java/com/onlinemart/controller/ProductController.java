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
import org.springframework.ui.ModelMap;
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

    @RequestMapping("/product")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello world! Inside Product hello");
        return "/product/hello";
    }

    @RequestMapping("/product/welcome")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome!, Inside Product welcome");
        return "/product/welcome";
    }

    

    @RequestMapping("/product/form")
    public String productAdd(Product product) {
        return "/product/form";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String saveUser(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/form";
        } else {
            productService.saveProduct(product);
        }
        return "redirect:/product/list";
    }

    @RequestMapping(value = "/product/list")
    public String listUsers(Model model) {
        model.addAttribute("products", productService.listProducts());
        return "product/list";
    }

    @RequestMapping("/product/edit/{productid}")
    public String editUser(@PathVariable("productid") int id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "product/form";
    }

    @RequestMapping("/product/delete/{productid}")
    public String deleteUser(@PathVariable("productid") int id, Model model) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }
    
}
