/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.CreditCard;
import com.onlinemart.model.Customer;
import com.onlinemart.service.CreditCardService;
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
 * @author psubedi
 */
@Controller
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CustomerService customerService;
    
    @RequestMapping("/creditcard")
    public void newCreditCard(ModelMap model){
        model.addAttribute("creditcard",null);
    }
    
//    @RequestMapping("/creditcard/addCreditCard/{customerid}")
//    public String addCredit(@PathVariable("customerid") Long id, Model model) {
//        model.addAttribute("selected", customerService.getCustomer(id));
//        System.out.println("credit card controller got it");
//        return "/creditcard/addCreditCard/";
//    }

    @RequestMapping(value = "/creditcard/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("creditcard") CreditCard creditCard, BindingResult result, HttpSession session, ModelMap model) {
        creditCardService.saveCreditCard(creditCard);
        model.addAttribute("creditcard", creditCard);
        return "/customer/account";
    }
    
}
