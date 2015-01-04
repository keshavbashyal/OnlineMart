/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import org.jboss.logging.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PTamang
 */
@Controller
@RequestMapping("/template")
public class TemplateController {
    @RequestMapping("/product")
    public String printProduct(ModelMap model) {
        System.out.println("reached in this function");
        model.addAttribute("message", "Welcome!");
        return "product/productdetails";
    }
    
    @RequestMapping ("/product/{productId}")
    public String printProductId(@PathVariable int productId){
        System.out.println("jpt is: " + productId);
        return "";
    }
}
