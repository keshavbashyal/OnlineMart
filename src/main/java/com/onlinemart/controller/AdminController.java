/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.service.CategoryService;
import com.onlinemart.service.CustomerService;
import com.onlinemart.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sBam
 */
@Controller
public class AdminController {

    @Autowired
    VendorService vendorService;
    @Autowired
    CustomerService customerService;
       @Autowired
  CategoryService categoryService;

    @RequestMapping("/admin/login")
    private ModelAndView showLoginPate() {
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping("/admin/welcome")
 
    public String home() {

        return "/admin/welcome";
    }

    @RequestMapping("/admin/dashboard")
 
    public String admin(Model model) {
        model.addAttribute("allvendors", vendorService.listVendors());
        model.addAttribute("customersize", customerService.listCustomer().size());
        model.addAttribute("allcustomers", customerService.listCustomer());
        model.addAttribute("vendorsize", vendorService.listVendors().size());
        model.addAttribute("allCategories", categoryService.listCategory());
        return "/admin/dashboard";
    }
    @RequestMapping("/admin/dashboard/categorylist")
    public String adminCategory(Model model){
     model.addAttribute("venders", vendorService.listVendors());
        return "/admin/dashboard";
    }
}