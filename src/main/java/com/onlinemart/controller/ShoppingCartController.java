/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.CreditCard;
import com.onlinemart.model.FinancialRecord;
import com.onlinemart.model.Orders;
import com.onlinemart.model.Product;
import com.onlinemart.model.ProductShoppingCart;
import com.onlinemart.model.ShoppingCart;
import com.onlinemart.model.User;
import com.onlinemart.service.ProductService;
import com.onlinemart.service.ShoppingCartService;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String addProductShoppingCart(@PathVariable("productid") Long productid, @RequestParam(value = "quantity", defaultValue = "1") Long quantity, Model model, HttpSession httpSession) {
        totalquantity = totalquantity + quantity; //Adding quantity in the fly
        ShoppingCart sessionShoppingCart = (ShoppingCart) httpSession.getAttribute("shoppingCart");

        //Checking if already cart exists in session
        if (sessionShoppingCart != null) {

            List<ProductShoppingCart> productShoppingCarts = sessionShoppingCart.getProductShoppingCart();

            for (ProductShoppingCart productShoppingCart : productShoppingCarts) {
                Product product = productShoppingCart.getProduct();
                Long sessionQuantity = productShoppingCart.getQuantity();
                //checking if the product is already available
                if (product.getId() == productid) {
                    productShoppingCart.setQuantity(quantity + sessionQuantity);
                    httpSession.setAttribute("totalquantity", totalquantity);
                    totalPrice = totalPrice + product.getUnitPrice() * quantity;
                    httpSession.setAttribute("totalprice", totalPrice);
                    return "redirect:/shoppingcart/productlist";

                }

            }
        }

        //for the shopping cart is not empty and the product is new product
        Product product = productService.getProduct(productid);
        ProductShoppingCart productShoppingCart = new ProductShoppingCart();

        productShoppingCart.setProduct(product);

        productShoppingCart.setQuantity(quantity);
        totalPrice = totalPrice + product.getUnitPrice() * quantity;
        shoppingCart.addProductShoppingCart(productShoppingCart);

        httpSession.setAttribute("shoppingCart", shoppingCart);
        httpSession.setAttribute("totalquantity", totalquantity);
        httpSession.setAttribute("totalprice", totalPrice);

        return "redirect:/shoppingcart/productlist";
    }

    @RequestMapping(value = "/shoppingcart/checkoutGuest")
    public String checkoutGuest(@Valid CreditCard creditcard, HttpSession httpSession) {

        //Order 
        Orders order = new Orders();
        order.setOrderDate(new Date());
        order.setTotalPrice(totalPrice);

        //Transaction
//        Transaction transaction = new Transaction();
//        transaction.setUser();
//        transaction.setAddress(customer.getAddress());
//        transaction.setCreditCard(customer.getCreditCard().get(1));
//        transaction.setGrossAmount(totalPrice * 0.8);
//        transaction.setTotalAmount(totalPrice);
//        transaction.setOrder(order);
//Checking the creditcard
        //RestTemplate restTemplate = new RestTemplate();
        //String result = restTemplate.getForObject("http://10.10.13.146:8080/cardgateway/webresources/verify/ccDetails?no=4854251425585698&requested=100", String.class);
        
        //For testing
        RestTemplate restTemplate = new RestTemplate();
        String result = "1";
        
        if (result.equals("1")) {
            //FinancialRecord to store in OnlineMart
            FinancialRecord financialRecord = new FinancialRecord();
            financialRecord.setCcNumbeer(50);
            financialRecord.setAmountToVendor(500F);

            financialRecord.setProfit(200F);
            financialRecord.setProfitToMycompany(100F);
            financialRecord.setTransactionId(3);
            financialRecord.setVendorId(1);
            financialRecord.setTotalAmount(400F);
            financialRecord.setDateOfTransaction(new Date());

            //Calling the RESTful webservices for posting financial data
            String uri = "http://localhost:8080/financialServiceProvider/webresources/entitiies.financialrecord";
            restTemplate.postForObject(uri, financialRecord, FinancialRecord.class);

            shoppingCart = new ShoppingCart();
            totalquantity = 0L;
            totalPrice = 0.0;

            httpSession.setAttribute("totalquantity", totalquantity);
            httpSession.setAttribute("totalprice", totalPrice);
            httpSession.setAttribute("shoppingCart", shoppingCart);

        } else if (result.equals("-1")) {
            return "shoppingcart/invalidcart";
        } else {
            return "shoppingcart/invalidamount";
        }

        return "redirect:/shoppingcart/productlist";
    }

    @RequestMapping(value = "/shoppingcart/checkout")
    public String checkout(HttpSession httpSession) {
        User user;
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/shoppingcart/addcreditcart";
        }
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
        //Checking the creditcard
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://10.10.13.146:8080/cardgateway/webresources/verify/ccDetails?no=4854251425585698&requested=100", String.class);

        if (result.equals("1")) {
            //FinancialRecord to store in OnlineMart
            FinancialRecord financialRecord = new FinancialRecord();
            financialRecord.setCcNumbeer(50);
            financialRecord.setAmountToVendor(500F);

            financialRecord.setProfit(200F);
            financialRecord.setProfitToMycompany(100F);
            financialRecord.setTransactionId(3);
            financialRecord.setVendorId(1);
            financialRecord.setTotalAmount(400F);
            financialRecord.setDateOfTransaction(new Date());

            //Calling the RESTful webservices for posting financial data
            String uri = "http://localhost:8080/financialServiceProvider/webresources/entitiies.financialrecord";
            restTemplate.postForObject(uri, financialRecord, FinancialRecord.class);

            shoppingCart = new ShoppingCart();
            totalquantity = 0L;
            totalPrice = 0.0;

            httpSession.setAttribute("totalquantity", totalquantity);
            httpSession.setAttribute("totalprice", totalPrice);
            httpSession.setAttribute("shoppingCart", shoppingCart);

        } else if (result.equals("-1")) {
            return "shoppingcart/invalidcart";
        } else {
            return "shoppingcart/invalidamount";
        }

        return "redirect:/shoppingcart/productlist";
    }

    @RequestMapping("shoppingcart/productshoppingcart/{id}")
    public String deleteProductShoppingCart(@PathVariable("id") Long id, Model model) {

        return "redirect:/shoppingcart/productlist";
    }

}
