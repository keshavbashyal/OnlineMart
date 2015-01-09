/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.Vendor;
import com.onlinemart.service.CategoryService;
import com.onlinemart.service.CustomerService;
import com.onlinemart.service.UserService;
import com.onlinemart.service.VendorService;
import java.security.Principal;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sBam
 */
@Controller
public class AdminController {

     @Autowired
    UserService userService;
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
 
    public String admin(Model model,HttpSession session, Principal princ) {
        session.setAttribute("user", userService.getByEmail(princ.getName()));
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
    
    
     @RequestMapping("admin/vendor/status/{id}")
    public String changeVendorStatus(@PathVariable Long id,   Model model, HttpSession session){
      Vendor v=vendorService.getVendor(id);
      
      if(v.getStatus().equalsIgnoreCase("PENDING"))
          v.setStatus("APPROVED");
      
      if(v.getStatus().equalsIgnoreCase("APPROVED"))
          v.setStatus("PENDING");
      
       
      vendorService.saveVendor(v);
      
    // model.addAttribute("venders", vendorService.listVendors());
        return "redirect:/admin/dashboard";
    }
    
    
     @RequestMapping("/admin/report")
    
    public String report(Model model){
     return "/admin/report";
    }
    
    
   
}
