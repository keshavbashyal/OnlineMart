/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.CreditCard;
import com.onlinemart.model.Customer;
import com.onlinemart.model.User;

import com.onlinemart.service.CreditCardService;
import com.onlinemart.service.CustomerService;
import com.onlinemart.service.UserRoleService;
import com.onlinemart.service.UserService;
import com.onlinemart.utils.MailService;
import java.security.Principal;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        User usr = (User) userService.getByEmail(princ.getName());
        session.setAttribute("user", usr);
        
       // User u=(User)session.getAttribute("user");
        Customer c = customerService.getCustomer(usr.getId());
        session.setAttribute("userType", "customer");
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
    public String saveUserCard(@ModelAttribute("card") CreditCard card,BindingResult result,HttpSession session) {
         
        //creditCardService.saveCreditCard(card);
        
        
         Customer cus=(Customer)session.getAttribute("user");
         cus.addCard(card);
         customerService.saveCustomer(cus);
        //System.out.println("card="+card.getCardNo());
        //model=new ModelAndView("/customer/account/");
         String model="/customer/account";
        if (result.hasErrors()) {
           //return model;
            System.out.println("error s");
        } else {
            
            //Customer cus=(Customer)session.getAttribute("user");
           
           //cus.addCard(card);
            
           // customerService.saveCustomer(cus);
           // model=new ModelAndView("/customer/account");
           // session.setAttribute("user", customer);
        }
       // return "redirect:/customer/account";
        
       // return null;
        return model;
    }


    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public String saveUser(@Valid Customer customer, BindingResult result, HttpSession session) throws MessagingException {
        if (result.hasErrors()) {
            return "customer/addCustomer";
        } else {
            customer.setUserRoles(userRoleService.getCustomer());
            String password=customer.getPassword();
            
             BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
            String hashedPassword = passwordEncoder.encode(password);  
  
            
                 
            customer.setPassword(hashedPassword);
            customerService.saveCustomer(customer);
            MailService sendEmail = new MailService();
            
            //SendEmail sendEmail = new SendEmail();
            //sendEmail.sendEmail(customer.getEmail(), "Hello", "How are yoiui");
            sendEmail.sendRegistrationEmail(customer.getEmail(),customer.getFname(),customer.getLname());
            session.setAttribute("user", customer);
        }
        return "redirect:/customer/dashboard";
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
    public String editAddress(@ModelAttribute("customer") Customer customer, Model model, HttpSession session) {
        //model.addAttribute("selected", customerService.getCustomer(id));
        //System.out.println("Accounts called for customer");
        Customer c = (Customer)session.getAttribute("user");
        model.addAttribute("customer", c);
        return "/customer/address";
    }
//    @RequestMapping("customer/creditcardsave")
//    public String addCreditCard(@Valid CreditCard creditcard, BindingResult result) {
//        
//    }
}
