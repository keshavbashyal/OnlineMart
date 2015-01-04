/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.Customer;
import com.onlinemart.service.CustomerService;
import javax.servlet.http.HttpSession;
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
public class CustomerController {

    @Autowired
    private CustomerService customerService;

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
    @RequestMapping("/customer/account")
    public String customerAccount(ModelMap model,HttpSession session) {
        Customer c = (Customer) session.getAttribute("user");
        if (c == null)
            return "/";
        else{
            model.addAttribute("customer",c);
            return "/customer/account";
        }
    }
    @RequestMapping("/customer/addCustomer")
    public String registerCustomer(ModelMap model){
        model.addAttribute("customer",new Customer());
        return "/customer/addCustomer";
    }
    
    @RequestMapping(value = "/customer/save" , method=RequestMethod.POST )
    public String saveUser(@Valid Customer customer, BindingResult result, HttpSession session){
        if (result.hasErrors()) {
            return "customer/addCustomer";
        } else {
            customerService.saveCustomer(customer);
            session.setAttribute("user", customer);
        }
        return "redirect:/customer/account";
    }
    @RequestMapping("/customer/list")
    public String listCustomer(ModelMap model){
        model.addAttribute("allcustomers" , customerService.listCustomer());
        return "/customer/list";
    }
    @RequestMapping("/customer/delete/{customerid}")
    public String deleteCustomer(@PathVariable("customerid") Long id, ModelMap model){
        customerService.deleteCustomer(id);
        return "/customer/list";
    }
    @RequestMapping("/customer/edit/{customerid}")
        public String editUser(@PathVariable("customerid") Long id, Model model) {
            model.addAttribute("selected",customerService.getCustomer(id));
        return "/customer/edit";
    }
//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public String saveCusoter(@ModelAttribute Customer customer, BindingResult result) {
//        customerService.saveCustomer(customer);
//        return "redirect:customer";
//    }

}
