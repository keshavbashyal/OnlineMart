package com.onlinemart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "/template/index";
	}

	@RequestMapping("/welcome")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Welcome!");
		return "welcome";
	}
}