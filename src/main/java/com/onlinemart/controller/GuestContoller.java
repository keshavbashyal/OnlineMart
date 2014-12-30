/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Keshav
 */
@Controller
public class GuestContoller {
    
    
    @RequestMapping("/guest")
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello world! Inside Guest hello");
		return "/guest/hello";
	}

	@RequestMapping("/guest/welcome")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Welcome!, Inside Guest welcome");
		return "/guest/welcome";
	}
}
