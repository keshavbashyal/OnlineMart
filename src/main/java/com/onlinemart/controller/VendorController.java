/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.commons.Color;
import com.onlinemart.commons.Sizes;
import com.onlinemart.model.Product;
import com.onlinemart.model.User;
import com.onlinemart.model.Vendor;
import com.onlinemart.service.ProductService;
import com.onlinemart.service.UserService;
import com.onlinemart.service.VendorService;
import java.security.Principal;
//import java.time.Clock;
import java.util.Date;
import javax.servlet.http.HttpSession;
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
public class VendorController {

    @Autowired
    UserService userService;
    @Autowired
    VendorService vendorService;
    @Autowired
    ProductService productService;

    @RequestMapping("/vendor/dashboard")
    public String vendorDashboard(ModelMap model, HttpSession session, Principal princ) {
         User usr=(User)userService.getByEmail(princ.getName());
        session.setAttribute("user", usr);

        
        Vendor vendor = (Vendor) usr;
        session.setAttribute("userType", "vendor");

        if (vendor.getStatus().equalsIgnoreCase("PENDING")) {
            session.removeAttribute("user");
            return "redirect:/login";
        } else {
            model.addAttribute("products", vendor.getProducts());
            return "/vendor/dashboard";
        }
    }
    
    

    @RequestMapping(value = "/vendor")
    public String vendorHome() {
        return "/vendor/dashboard";
    }

    @RequestMapping(value = "/vendor/welcome")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome!, Inside Vendor welcome");
        return "/vendor/welcome";
    }

    @RequestMapping("/vendor/form")
    public String vendorAdd(Vendor vendor) {
        return "/vendor/form";
    }

    @RequestMapping(value = "/vendor/save", method = RequestMethod.POST)
    public String saveUser(@Valid Vendor vendor, BindingResult result) {
        if (result.hasErrors()) {
            return "vendor/form";
        } else {

            if (vendor.getPassword().equals(vendor.getRepassword())) {
                vendor.setRegisterDate(new Date());
                vendor.setStatus("PENDING");
                vendorService.saveVendor(vendor);
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/vendor/list")
    public String listUsers(Model model) {
        model.addAttribute("vendors", vendorService.listVendors());
        return "vendor/list";
    }

    @RequestMapping("/vendor/edit/{vendorid}")
    public String editUser(@PathVariable("vendorid") Long id, Model model) {
        model.addAttribute("vendor", vendorService.getVendor(id));
        return "vendor/form";
    }

    @RequestMapping("/vendor/save/{vendorid}")
    public String varify(@Valid Vendor vendor, BindingResult result) {
        vendor.setStatus("APPROVED");
        vendorService.saveVendor(vendor);
        return "redirect:/vendor/list";
    }

    @RequestMapping("/vendor/vendorVarification/{vendorid}")
    public String varifyvander(@PathVariable("vendorid") Long id, Model model) {
        model.addAttribute("vendor", vendorService.getVendor(id));
        return "vendor/vendorVarification";
    }

    @RequestMapping("/vendor/delete/{vendorid}")
    public String deleteUser(@PathVariable("vendorid") Long id, Model model) {
        vendorService.deleteVendor(id);
        return "redirect:/vendor/list";
    }

    // Product Add form
    @RequestMapping("vendor/productaddfrm")
    public String productAddForm(Product product, Model model) {
        model.addAttribute("enum_size", Sizes.values());
        model.addAttribute("enum_color", Color.values());
        return "vendor/productAddForm";
    }

    @RequestMapping(value = "/vendor/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid Product product, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            model.addAttribute("errType", "alert error");
            model.addAttribute("msg", result.toString());
            //return "vendor/dashboard";
        } else {
            Vendor vendor = (Vendor) session.getAttribute("user");
            product.setVendor(vendor);
            vendor.addProduct(product);
            //vendorService.saveVendor(vendor);
            productService.saveProduct(product);
            model.addAttribute("errType", "alert success");
            model.addAttribute("msg", " Successfully Added. ");
        }
        return "redirect:/vendor/dashboard";
    }

}
