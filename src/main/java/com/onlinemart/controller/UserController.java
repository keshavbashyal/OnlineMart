/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kBhattarai
 */
@Controller
public class UserController {
    
    
    @RequestMapping("/login")
    private ModelAndView showLoginPate(){
        ModelAndView model=new ModelAndView("login");
       return model;
    }
    
    
    @RequestMapping("/home")
    @ResponseBody
    public String home(){
        
        return "hello you are in home page";
    }
    
    
    @RequestMapping("/admin")
    @ResponseBody
    public String admin(){
        return "hello you are in admin page";
    }
}
