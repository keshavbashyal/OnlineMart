/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.Vendor;
import com.onlinemart.service.VendorService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Keshav
 */
@Controller
public class VendorController {
    
//   @Autowired
//    private VendorService vendorService;
    
    @RequestMapping("/vendor")
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello world! Inside Vendor hello");
		return "/vendor/hello";
	}

	@RequestMapping("/vendor/welcome")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Welcome!, Inside Vendor welcome");
		return "/vendor/welcome";
	}
        
//        @RequestMapping(value = "vendor")
//    public String listCampaign(Map<String, Object> map) {
//        map.put("campaignList", vendorService.listVendors());
//        return "/campaign/list";
//    }

    
//    @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String addCampaign(Map<String,Object> map)
//    {
//        map.put("vendor", new Vendor());
//        return "/vendor/addEdit";
//    }
//    
//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public String updateVendor(@ModelAttribute Vendor vendor, BindingResult result)
//    {
//        vendorService.saveVendor(vendor);
//        return "redirect:/vendor";
//    }
//    
//    @RequestMapping(value = "{id}")
//    public String getCampaign(@PathVariable int id, Map<String,Object> map)
//    {
//        map.put("vendor", vendorService.getVendor(id));
//        return "/vendor/addEdit";
//    }
    
}
