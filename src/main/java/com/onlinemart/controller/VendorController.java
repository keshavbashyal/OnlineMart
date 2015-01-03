/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.Vendor;
import com.onlinemart.service.VendorService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    VendorService vendorService;

    @RequestMapping("/vendor")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello world! Inside Vendor hello");
        return "/vendor/dashboard";
    }

    @RequestMapping("/vendor/welcome")
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
            vendorService.saveVendor(vendor);
        }
        return "redirect:/vendor/list";
    }

    @RequestMapping(value = "/vendor/list")
    public String listUsers(Model model) {
        model.addAttribute("vendors", vendorService.getAllVendors());
        return "vendor/list";
    }

    @RequestMapping("/vendor/edit/{vendorid}")
    public String editUser(@PathVariable("vendorid") int id, Model model) {
        model.addAttribute("vendor", vendorService.getVendorById(id));
        return "vendor/form";
    }

    @RequestMapping("/vendor/delete/{vendorid}")
    public String deleteUser(@PathVariable("vendorid") int id, Model model) {
        vendorService.deleteVendor(id);
        return "redirect:/vendor/list";
    }
     @RequestMapping("/vendor/productform")
    public String vendorProductForm(Vendor vendor) {
        return "/vendor/productform";
    }
     @RequestMapping("/vendor/productlist")
    public String vendorProductList(Vendor vendor) {
        return "/vendor/productlist";
    }

}
