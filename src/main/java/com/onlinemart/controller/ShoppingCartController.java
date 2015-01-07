/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.CreditCard;
import com.onlinemart.model.Customer;
import com.onlinemart.model.Orders;
import com.onlinemart.model.Product;
import com.onlinemart.model.ProductShoppingCart;
import com.onlinemart.model.ShoppingCart;
import com.onlinemart.model.Transaction;
import com.onlinemart.model.User;
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
import org.springframework.web.bind.annotation.RequestParam;

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

    private Long totalquantity = 0L;

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
            Orders order = new Orders();
            order.setOrderDate(new Date());
            order.setTotalPrice(totalPrice);
            //customer.addOrder(order);

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
    public String addProductShoppingCart(@PathVariable("productid") Long productid, @RequestParam(value="quantity" ,defaultValue = "1") Long quantity,Model model, HttpSession httpSession) {
//        ShoppingCart sessionShoppingCart = (ShoppingCart) httpSession.getAttribute("shoppingCart");
//        if (sessionShoppingCart !=null)
//        {
//            List<ProductShoppingCart> productShoppingCarts = sessionShoppingCart.getProductShoppingCart();
//            //List<Product> products = productShoppingCarts
//           
//            
//            
//        }

        
        Product product = productService.getProduct(productid);
        ProductShoppingCart productShoppingCart = new ProductShoppingCart();
        productShoppingCart.setProduct(product);
        
        productShoppingCart.setQuantity(quantity);  
        totalquantity = totalquantity + quantity; 
        
        shoppingCart.addProductShoppingCart(productShoppingCart);
        httpSession.setAttribute("shoppingCart", shoppingCart);
        httpSession.setAttribute("totalquantity", totalquantity);
        httpSession.setAttribute("totalprice", totalPrice);
        
        
        
        
        return "redirect:/shoppingcart/productlist";
    }
    
    
    @RequestMapping(value = "/shoppingcart/checkout")
    public String checkout( HttpSession httpSession) {
        User user;
//        if (httpSession.getAttribute("user")==null){
//            return "redirect:/shoppingcart/addcreditcart";
//            
//        }
//        else {
//            user = (User)httpSession.getAttribute("user");
//            
//            
//        }         
        
//            user = (User)httpSession.getAttribute("user");
//            //Order 
//            Orders order = new Orders();
//            order.setOrderDate(new Date());
//            order.setTotalPrice(totalPrice);
//            
//            //Transaction
//            Customer customer = (Customer)user;
//            
//            Transaction transaction = new Transaction();
//            transaction.setUser(customer);
//            transaction.setAddress(customer.getAddress());
//            transaction.setCreditCard(customer.getCreditCard().get(1));
//            transaction.setGrossAmount(totalPrice*0.8);
//            transaction.setTotalAmount(totalPrice);
//            transaction.setOrder(order);
//       
        shoppingCart = new ShoppingCart();
        totalquantity = 0L;
        
        httpSession.setAttribute("totalquantity", totalquantity);
        httpSession.setAttribute("shoppingCart", shoppingCart);
        
        return "redirect:/shoppingcart/productlist";
    }
    
    @RequestMapping("shoppingcart/productshoppingcart/{id}")
    public String deleteProductShoppingCart(@PathVariable("id") Long id, Model model) {
        
        return "redirect:/shoppingcart/productlist";
    }

}
