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
import com.onlinemart.service.UserRoleService;
import com.onlinemart.service.UserService;
import java.security.Principal;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Keshav
 */
@Controller
public class CustomerController {

     @Autowired
    UserService userService;
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private CreditCardService creditCardService;
    
    @Autowired
    private UserRoleService userRoleService;
    
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

    @RequestMapping("/customer/dashboard")
    public String customerAccount(ModelMap model,HttpSession session, Principal princ) {
        session.setAttribute("user", userService.getByEmail(princ.getName()));
        Customer c = (Customer)session.getAttribute("user");
        System.out.println(userRoleService.getCustomer().getRole());
        if (c == null) {
           // session.setAttribute("selected", customerService.getCustomer(1L));
            return "/login";

        } else {
            session.setAttribute("selected", c);
            return "/customer/account";
        }
    }

    @RequestMapping("/customer/addCustomer")
    public String registerCustomer(ModelMap model) {
        model.addAttribute("customer", new Customer());
        return "/customer/addCustomer";
    }
    
   @RequestMapping(value = "/customer/card/save", method = RequestMethod.POST)
    public ModelAndView saveUserCard(@ModelAttribute("card") CreditCard card,BindingResult result,HttpSession session) {
        ModelAndView model=new ModelAndView("/customer/dashboard/");
        if (result.hasErrors()) {
            return model;
        } else {
            
            Customer cus=(Customer)session.getAttribute("user");
            //creditCardService.saveCreditCard(card);
            cus.addCard(card);
            
            customerService.saveCustomer(cus);
            model=new ModelAndView("/customer/account");
           // session.setAttribute("user", customer);
        }
       // return "redirect:/customer/account";
        
       // return null;
        return model;
    }

    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public String saveUser(@Valid Customer customer, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "customer/addCustomer";
        } else {
            customer.setUserRoles(userRoleService.getCustomer());
            customerService.saveCustomer(customer);
            session.setAttribute("user", customer);
        }
        return "redirect:/customer/account";
    }

    @RequestMapping("/customer/list")
    public String listCustomer(ModelMap model) {
        model.addAttribute("allcustomers", customerService.listCustomer());
        return "/customer/list";
    }

    @RequestMapping("/customer/delete/{customerid}")
    public String deleteCustomer(@PathVariable("customerid") Long id, ModelMap model) {
        customerService.deleteCustomer(id);
        return "/customer/list";
    }

    @RequestMapping("/customer/edit/{customerid}")
    public String editUser(@PathVariable("customerid") Long id, Model model) {
        model.addAttribute("selected", customerService.getCustomer(id));
        return "/customer/edit";
    }

    @RequestMapping("/customer/addCreditCard/{customerid}")
    public String addCredit(@PathVariable("customerid") Long id, Model model) {
        //model.addAttribute("selected", customerService.getCustomer(id));
        System.out.println("Accounts called for customer");
        return "/creditcard/addCreditCard";
    }

    @RequestMapping("/customer/change")
    public String changePassword(Model model) {
        //model.addAttribute("selected", customerService.getCustomer(id));
        //System.out.println("Accounts called for customer");
        return "/customer/change";
    }
    @RequestMapping("customer/creditcard")
    public String redirectCreditCard(Model model) {
         //model.addAttribute("selected", customerService.getCustomer(id));
        //System.out.println("Accounts called for customer");
        model.addAttribute("creditcard", null);
        return "/customer/creditcard";
    }
    @RequestMapping("customer/address")
    public String editAddress(Model model) {
        //model.addAttribute("selected", customerService.getCustomer(id));
        //System.out.println("Accounts called for customer");
        return "/customer/address";
    }
//    @RequestMapping("customer/creditcardsave")
//    public String addCreditCard(@Valid CreditCard creditcard, BindingResult result) {
//        
//    }
}
