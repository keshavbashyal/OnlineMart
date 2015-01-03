/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.Product;
import com.onlinemart.model.Vendor;
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

    @RequestMapping("/products")
    public String products(ModelMap model) {
        model.addAttribute("message", "Hello world! Inside Vendor hello");
        return "/productlist";
    }
    
    @RequestMapping("/{vendorid}/products")
    public String prLongHello(ModelMap model) {
        model.addAttribute("message", "Hello world! Inside Vendor hello");
        return "/vendor/productlist";
    }
    

    @RequestMapping("/product/form")
    public String vendorAdd(Vendor vendor) {
        return "/product/form";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String saveUser(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "vendor/form";
        } else {
            productService.saveProduct(product);
        }
        return "redirect:/product/productlist";
    }

    @RequestMapping(value = "/product/list")
    public String listUsers(Model model) {
//        model.addAttribute("vendors", productService.get);
        return "/product/productlist";
    }

    @RequestMapping("/product/edit/{vendorid}")
    public String editUser(@PathVariable("vendorid") Long id, Model model) {
//        model.addAttribute("vendor", vendorService.getVendorById(id));
        return "/product/form";
    }

    @RequestMapping("/product/delete/{vendorid}")
    public String deleteUser(@PathVariable("vendorid") Long id, Model model) {
//        vendorService.deleteVendor(id);
        return "redirect:/product/list";
    }
}
