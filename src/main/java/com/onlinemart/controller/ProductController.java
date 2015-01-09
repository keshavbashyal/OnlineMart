/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import static com.businessobjects.reports.datainterface.SummaryOperation.p;
import com.onlinemart.model.Product;
import com.onlinemart.model.Vendor;
import com.onlinemart.service.CategoryService;
import com.onlinemart.service.ProductService;
import com.onlinemart.service.VendorService;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Keshav
 */
@Controller
public class ProductController {

    @Autowired
    VendorService vendorService;

    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;

    

    @RequestMapping(value = "vendor/product/save", method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "vendor/productform";
        } else {
            productService.saveProduct(product);
        }
        return "redirect:/vendor/productlist";
    }

    @RequestMapping(value = "/vendor/productlist")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listProducts());
        return "vendor/productlist";
    }

    @RequestMapping(value = "/vendor/{vendorid}/productlist")
    public String listProductsByVendorId(@PathVariable("vendorid") Long id, Model model) {
        Vendor vendor = vendorService.getVendor(id);
        model.addAttribute("products", vendor.getProducts());
        return "vendor/productlist";
    }

    @RequestMapping("vendor/product/edit/{productid}")
    public String editProduct(@PathVariable("productid") Long id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("categories", categoryService.listCategory());
        return "vendor/productEditFrm";
    }

    @RequestMapping("vendor/product/delete/{productid}")
    public String deleteProduct(@PathVariable("productid") Long id, Model model, HttpSession session) {
        Vendor vendor = (Vendor) session.getAttribute("user");
        System.out.println(vendor.getEmail());
        vendor.removeProduct(productService.getProduct(id));
        vendorService.saveVendor(vendor);
        //productService.deleteProduct(id);
        
        return "redirect:/vendor/dashboard";
    }

    @RequestMapping("/vendor/productform")
    public String vendorProductForm(Product product) {
        return "/vendor/productform";
    }

    

    @RequestMapping("/product/productlist")
    public String addproductShoppingcart(Model model, HttpSession session) {
        model.addAttribute("products", productService.listProducts());
        return "product/productlist";
    }

    @RequestMapping("/product/{productid}/productdetail")
    public String productDetail(@PathVariable("productid") Long id, Model model, HttpServletResponse response) {
        Product product = productService.getProduct(id);

        model.addAttribute("product", product);
        return "product/productdetail";
    }
    
    
    @RequestMapping(value = "/product/search", method = RequestMethod.POST)
    public String findproduct(@RequestParam("search") String search, Model model)  {
        
       // model.addAttribute("products", productService.findProductByName(search));
        return "redirect:/product/search/"+search;
        //return null;
    }
     @RequestMapping(value = "/product/search/{search}", method = RequestMethod.GET)
    public String findproductFromSearch(@PathVariable("search") String search, Model model)  {
        
        model.addAttribute("search", search);
        
        model.addAttribute("products", productService.findProductByName(search));
        return "product/productlist";
        //return null;
    }
}

    


