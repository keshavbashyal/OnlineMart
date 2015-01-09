/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.CreditCard;
import com.onlinemart.model.Customer;
import com.onlinemart.model.FinancialRecord;
import com.onlinemart.model.Orders;
import com.onlinemart.model.Product;
import com.onlinemart.model.ProductShoppingCart;
import com.onlinemart.model.ShoppingCart;
import com.onlinemart.model.Transaction;
import com.onlinemart.model.User;
import com.onlinemart.service.CustomerService;
import com.onlinemart.service.FinancialRecordService;
import com.onlinemart.service.OrderService;
import com.onlinemart.service.ProductService;
import com.onlinemart.service.SalesService;
import com.onlinemart.service.ShoppingCartService;
import com.onlinemart.service.TransactionService;
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

    @Autowired
    TransactionService transactionService;

    @Autowired
    FinancialRecordService financialRecordService;

    @Autowired
    SalesService salesService;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    private ShoppingCart shoppingCart = new ShoppingCart();

    private Long totalquantity = 0L;

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
        shoppingCart = (ShoppingCart) httpSession.getAttribute("shoppingCart");
        //model.addAttribute("productShoppingCart", shoppingCart.getProductShoppingCart());

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

    @RequestMapping(value = "/shoppingcart/checkoutCreditcard")
    public String checkoutGuest(@Valid CreditCard creditcard, HttpSession httpSession,Model model) {

        shoppingCart = (ShoppingCart) httpSession.getAttribute("shoppingcart");
        //Order 
        Orders order = new Orders();
        order.setOrderDate(new Date());
        order.setTotalPrice(totalPrice);
        orderService.saveOrder(order);

        //Transaction
        System.out.println("before transaction");

        Transaction transaction = new Transaction();
//        transaction.setUser(c);
//        transaction.setAddress(c.getAddress());
        transaction.setCreditCard(creditcard);
        transaction.setGrossAmount(totalPrice * 0.8);
        transaction.setTotalAmount(totalPrice);
        transaction.setOrder(order);
        transaction.setShoppingCart(shoppingCart);
        transaction.setTxnStatus("Success");

        transactionService.saveTransaction(transaction);

        //Saving transactionService and salesSercive  
//        salesService.addSalesFromTransaction(transaction);
        //Checking the creditcard
        RestTemplate restTemplate = new RestTemplate();
        try {
            //String result1 = restTemplate.getForObject("http://10.10.11.231:8080/PaymentGateway/webresources/verify/ccDetails?no=4584225423162589&requested=100", String.class);

        } catch (Exception e) {
            System.out.println("Exception caught" + e.getMessage());
        }
        String result1 = "1";

        if (result1.equals("1")) {
            //FinancialRecord to store in OnlineMart
            FinancialRecord financialRecord = new FinancialRecord();
            System.out.println("The value of creditCard Number is"+ creditcard.getCardNo());
            financialRecord.setCcNumbeer(creditcard.getCardNo());
            financialRecord.setAmountToVendor(totalPrice);

            financialRecord.setProfit(totalPrice * 0.1);
            financialRecord.setProfitToMycompany(totalPrice * 0.2);
            financialRecord.setTransactionId(transaction.getId());
//            financialRecord.setVendorId(1);
            financialRecord.setTotalAmount(totalPrice);
            financialRecord.setDateOfTransaction(new Date());

            financialRecordService.saveFinancialRecord(financialRecord);

             //Calling the RESTful webservices for posting financial data
            try {
                
                String uri = "http://10.10.56.170:8080/com.Testmyfiance_FinancialServiceProvider_war_1.0-SNAPSHOT/webresources/entitiies.financialrecord";
                restTemplate.postForObject(uri, financialRecord, FinancialRecord.class);
            } catch (Exception e) {
                System.out.println("Exception Caught " + e.getMessage());
            }

            shoppingCart = new ShoppingCart();
            totalquantity = 0L;
            totalPrice = 0.0;

            httpSession.setAttribute("totalquantity", totalquantity);
            httpSession.setAttribute("totalprice", totalPrice);
            httpSession.setAttribute("shoppingCart", shoppingCart);
            model.addAttribute("creditcarderror","The checkout is successfully completed");
            return "shoppingcart/error";

        } else if (result1.equals("-1")) {
            model.addAttribute("creditcarderror","Invalid creditcard");
            return "shoppingcart/error";
        } else if (result1.equals("0")) {
            model.addAttribute("creditcarderror","The amount is unavailable in creditcard");
            return "shoppingcart/error";
        }

        return "redirect:/shoppingcart/productlist";

    }

    @RequestMapping(value = "/shoppingcart/addcreditcart")
    public String creditcardadd(HttpSession httpSession) {
        return "/shoppingcart/addcreditcard";
    }

    @RequestMapping(value = "/shoppingcart/checkout")
    public String checkout(HttpSession httpSession,Model model) {
        User user;
        if (httpSession.getAttribute("user") == null) {
            System.out.println("Inside not session");
            return "redirect:/shoppingcart/addcreditcart";
        } else {
            System.out.println("Inside session");
            user = (User) httpSession.getAttribute("user");
        }

        if (!(user instanceof Customer)) {
            System.out.println("Inside Customer.class check");
            return "redirect:/shoppingcart/unabletochekout";
        }

        if (((Customer) user).getCreditCard().isEmpty()) {
            return "/customer/creditcard";

        }

        shoppingCart = (ShoppingCart) httpSession.getAttribute("shoppingcart");
        Customer c = (Customer) user;

        //Order 
        System.out.println("Inside Order");
        Orders order = new Orders();
        order.setOrderDate(new Date());
        order.setTotalPrice(totalPrice);
        c.addOrders(order);
        orderService.saveOrder(order);

//        for (CreditCard creditCard : c.getCreditCard()) {
//            creditCard 
//        
//        }
        
        

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAddress(c.getAddress());
        transaction.setCreditCard(c.getCreditCard().get(0));
        transaction.setGrossAmount(totalPrice * 0.8);
        transaction.setTotalAmount(totalPrice);
        transaction.setOrder(order);
        transaction.setShoppingCart(shoppingCart);
        transaction.setTxnStatus("Success");

        transactionService.saveTransaction(transaction);

        //Saving transactionService and salesService  
        // salesService.addSalesFromTransaction(transaction);
        System.out.println("after TransactionService");

        //Checking the creditcard
        RestTemplate restTemplate = new RestTemplate();

        try {
            //String result = restTemplate.getForObject("http://10.10.13.146:8080/cardgateway/webresources/verify/ccDetails?no=4854251425585698&requested=100", String.class);
        } catch (Exception e) {
            System.out.println("Exception Caught" + e.getMessage());
        }

        String result = "1";

        if (result.equals("1")) {
            //FinancialRecord to store in OnlineMart
            System.out.println("Before FinancialRecord");
            FinancialRecord financialRecord = new FinancialRecord();
            
            financialRecord.setCcNumbeer(c.getCreditCard().get(0).getCardNo());
            financialRecord.setAmountToVendor(totalPrice * 0.8);
            financialRecord.setProfit(totalPrice * 0.1);
            financialRecord.setProfitToMycompany(totalPrice * 0.1);
            financialRecord.setTransactionId(transaction.getId());
            financialRecord.setVendorId(1L);
            financialRecord.setTotalAmount(totalPrice);
            financialRecord.setDateOfTransaction(new Date());
            

            financialRecordService.saveFinancialRecord(financialRecord);

            System.out.println("After FinancialRecordService");

            //Calling the RESTful webservices for posting financial data
            try {
                
                String uri = "http://10.10.56.170:8080/com.Testmyfiance_FinancialServiceProvider_war_1.0-SNAPSHOT/webresources/entitiies.financialrecord";
                restTemplate.postForObject(uri, financialRecord, FinancialRecord.class);
            } catch (Exception e) {
                System.out.println("Exception Caught " + e.getMessage());
            }

            
            shoppingCart = new ShoppingCart();
            totalquantity = 0L;
            totalPrice = 0.0;

            httpSession.setAttribute("totalquantity", totalquantity);
            httpSession.setAttribute("totalprice", totalPrice);
            httpSession.setAttribute("shoppingCart", shoppingCart);

            model.addAttribute("creditcarderror","The checkout is successfully completed");
            return "shoppingcart/error";

        } else if (result.equals("-1")) {
            model.addAttribute("creditcarderror","Invalid creditcard");
            return "shoppingcart/error";
        } else if (result.equals("0")){
            model.addAttribute("creditcarderror","The amount is unavailable in creditcard");
            return "shoppingcart/error";
        }

        return "redirect:/shoppingcart/productlist";

    }


    @RequestMapping("shoppingcart/productshoppingcart/{id}")
    public String deleteProductShoppingCart(@PathVariable("id") Long id, Model model) {

        return "redirect:/shoppingcart/productlist";
    }

}
