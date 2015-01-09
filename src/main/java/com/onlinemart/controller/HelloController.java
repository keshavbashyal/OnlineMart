package com.onlinemart.controller;

import com.onlinemart.service.CategoryService;
import com.onlinemart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String printHello(Model model) {

        model.addAttribute("allCategories", categoryService.listCategory());
        model.addAttribute("products", productService.listProducts());
        return "template/index";
    }

        

	@RequestMapping("/welcome")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Welcome!");
		return "welcome";
	}
        @RequestMapping("/category/{categoryid}/products")
    public String SearchProductByCateegory(@PathVariable("categoryid") Long id, Model model) {
        model.addAttribute("products", productService.findProductByCategoryId(id));
        return "product/productlist";
    }
    
}

