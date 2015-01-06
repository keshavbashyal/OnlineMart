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
import com.onlinemart.service.ProductService;
import com.onlinemart.service.ShoppingCartService;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Keshav
 */
@Controller
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;
    
    @Autowired
    ProductService productService;
    
    
    private ShoppingCart shoppingCart = new ShoppingCart();
    
    private int totalQuantity = 0;

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
            Product product = productShoppingCart.getProduct();
            totalPrice += product.getUnitPrice() * productShoppingCart.getQuantity();

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

    @RequestMapping("/shoppingcart/edit/{shoppingid}")
    public String editUser(@PathVariable("shoppingid") int id, Model model) {
        model.addAttribute("shopping", shoppingCartService.getShoppingCart(id));
        return "shoppingcart/form";
    }

    @RequestMapping("/shoppingcart/delete/{shoppingid}")
    public String deleteUser(@PathVariable("shoppingid") int id, Model model) {
        shoppingCartService.deleteShoppingCart(id);
        return "redirect:/shoppingcart/list";
    }

    @RequestMapping("/shoppingcart/productlist")
    public String shoppingCartProductList(Model model, HttpSession httpSession) {
        ShoppingCart shoppingCart = (ShoppingCart) httpSession.getAttribute("shoppingCart");
//        model.addAttribute("productShoppingCart", shoppingCart.getProductShoppingCart());
       
        return "/shoppingcart/productlist";
    }
 
    
    @RequestMapping(value = "/shoppingcart/addProduct/{productid}")
    public String addProductShoppingCart(@PathVariable("productid")  Long productid,Model model, HttpSession httpSession) {
        System.out.println("The name of the product is " + productid);
        
        Product product = productService.getProduct(productid);
        ProductShoppingCart productShoppingCart =new ProductShoppingCart();
        productShoppingCart.setProduct(product);
        productShoppingCart.setQuantity(totalQuantity);
        totalQuantity = productShoppingCart.getQuantity();
        productShoppingCart.setQuantity(totalQuantity);
        
        shoppingCart.addProductShoppingCart(productShoppingCart);
        httpSession.setAttribute("shoppingCart", shoppingCart);
        
        return "redirect:/shoppingcart/productlist";
    }

}
