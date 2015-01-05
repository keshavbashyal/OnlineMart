/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.Category;
import com.onlinemart.service.CategoryService;
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

/**
 *
 * @author sBam
 */
@Controller
public class CategoryController {
     @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello world! Inside category hello");
        return "/category/hello";
    }

    @RequestMapping("/category/welcome")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome!, Inside category welcome");
        return "/category/welcome";
    }
    @RequestMapping("/category/account")
    public String categoryAccount(ModelMap model,HttpSession session) {
        Category c = (Category) session.getAttribute("user");
        if (c == null)
            return "/";
        else{
            model.addAttribute("category",c);
            return "/category/account";
        }
    }
    @RequestMapping("/category/addCategory")
    public String registerCAtegory(ModelMap model){
        model.addAttribute("category",new Category());
        return "/category/addCategory";
    }
    
    @RequestMapping(value = "/category/save" , method=RequestMethod.POST )
    public String saveCategory(@Valid Category category, BindingResult result, HttpSession session){
        if (result.hasErrors()) {
            return "category/addCategory";
        } else {
            categoryService.saveCategory(category);
        }
        return "redirect:/category/list";
    }
    
    @RequestMapping(value = "/category/addCategory" , method=RequestMethod.POST )
    public String addCategory(@Valid Category category, BindingResult result, HttpSession session){
        
        return "/category/addCategory";
    }
    
    
    @RequestMapping("/category/list")
    public String listCustomer(ModelMap model){
        model.addAttribute("allCategories" , categoryService.listCategory());
        return "/category/list";
    }
    @RequestMapping("/category/delete/{categoryid}")
    public String deleteCustomer(@PathVariable("categoryid") Long id, ModelMap model){
        categoryService.deleteCategory(id);
        return "redirect:/category/list";
    }
    @RequestMapping("/category/edit/{categoryid}")
        public String editUser(@PathVariable("categoryid") Long id, Model model) {
            model.addAttribute("category",categoryService.getCategory(id));
        return "redirect:/category/list";
    }
    
}
