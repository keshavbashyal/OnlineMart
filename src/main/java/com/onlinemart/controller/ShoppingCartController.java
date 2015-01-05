/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.CreditCard;
import com.onlinemart.model.Customer;
import com.onlinemart.model.Order;
import com.onlinemart.model.Product;
import com.onlinemart.model.ProductShoppingCart;
import com.onlinemart.model.ShoppingCart;
import com.onlinemart.service.ShoppingCartService;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Keshav
 */
@Controller
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;
    
//    @Autowired
//    OrderService orderService;

    private Double totalPrice = 0.0;

    @RequestMapping("/restapi/{id}")
    public String restAPI(ModelMap model, @PathVariable("id") int id, HttpSession session) throws IOException {
        model.addAttribute("message", "Hello world! Inside Shopping hello");

        Customer customer = (Customer) session.getAttribute("user");

        //Adding the total price in Shopping cart        
        ShoppingCart cart;

        if ((ShoppingCart) session.getAttribute("shoppingcart") == null) {
            cart = new ShoppingCart();
        } else {
            cart = shoppingCartService.getShoppingCart(id);
        }

        for (Iterator<ProductShoppingCart> it = cart.getProductShoppingCart().iterator();
                it.hasNext();) {
            ProductShoppingCart productShoppingCart = it.next();
            for (Product product : productShoppingCart.getProducts()) {
                totalPrice += product.getUnitPrice();
            }

        }

        //Validating the credit card
        List<CreditCard> creditCards = customer.getCreditCard();
        CreditCard creditCard = creditCards.get(1);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://10.10.13.146:8080/cardgateway/webresources/verify/ccDetails?no=" + creditCard.getCardNo() + "&requested=" + totalPrice, String.class);

        System.out.println("The return value is " + result);
        model.addAttribute("message", "Hello ! Your transaction is completed " + result);

        int a = Integer.parseInt(result);
        if (a == 1) {
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setTotalPrice(totalPrice);
            customer.addOrder(order);

//            session.setAttribute("shoppingcart","")
        }

        return "template/index";

    }

    @RequestMapping("/shopping/welcome")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome!, Inside Shopping welcome");
        return "/shoppingcart/welcome";
    }

    @RequestMapping("/shopping/form")
    public String shoppingAdd(ShoppingCart shoppingCart) {
        return "/shoppingcart/form";
    }

    @RequestMapping(value = "/shopping/save", method = RequestMethod.POST)
    public String saveUser(@Valid ShoppingCart shoppingCart, BindingResult result) {
        if (result.hasErrors()) {
            return "shoppingcart/form";
        } else {
            shoppingCartService.saveShoppingCart(shoppingCart);
        }
        return "redirect:/shoppingcart/list";
    }

    @RequestMapping(value = "/shoppingcart/list")
    public String listUsers(Model model) {
        model.addAttribute("shoppings", shoppingCartService.listShoppingCart());
        return "shoppingcart/list";
    }

    @RequestMapping("/shopping/edit/{shoppingid}")
    public String editUser(@PathVariable("shoppingid") int id, Model model) {
        model.addAttribute("shopping", shoppingCartService.getShoppingCart(id));
        return "shoppingcart/form";
    }

    @RequestMapping("/shopping/delete/{shoppingid}")
    public String deleteUser(@PathVariable("shoppingid") int id, Model model) {
        shoppingCartService.deleteShoppingCart(id);
        return "redirect:/shoppingcart/list";
    }

}
