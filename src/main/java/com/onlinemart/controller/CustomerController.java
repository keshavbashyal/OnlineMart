/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.Customer;
import com.onlinemart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Keshav
 */

@Controller
public class CustomerController {

//    @Autowired
//    private CustomerService customerService;

    @RequestMapping("/customer")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello world! Inside Customer hello");
        return "/customer/hello";
    }

    @RequestMapping("/customer/welcome")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome!, Inside Customer welcome");
        return "/customer/welcome";
    }

//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public String saveCusoter(@ModelAttribute Customer customer, BindingResult result) {
//        customerService.saveCustomer(customer);
//        return "redirect:customer";
//    }

}
