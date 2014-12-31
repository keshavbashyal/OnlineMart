package com.onlinemart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/")
	public ModelAndView printHello() {
            ModelAndView model=new ModelAndView("/template/index");
		model.addObject("message", "Hello world!");
                
		return model;
	}
        

	@RequestMapping("/welcome")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Welcome!");
		return "welcome";
	}
}