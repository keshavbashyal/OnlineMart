/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.commons.Color;
import com.onlinemart.commons.Sizes;
import com.onlinemart.model.Product;
import com.onlinemart.model.User;
import com.onlinemart.model.Vendor;
import com.onlinemart.service.CategoryService;
import com.onlinemart.service.ProductService;
import com.onlinemart.service.UserRoleService;
import com.onlinemart.service.UserService;
import com.onlinemart.service.VendorService;
import com.onlinemart.utils.MailService;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.Clock;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Keshav
 */
@Controller
public class VendorController {

    @Autowired
    UserService userService;
    @Autowired
    VendorService vendorService;
    @Autowired
    ProductService productService;
    @Autowired
    UserRoleService UserRoleService;
    @Autowired
    CategoryService categoryService;

 @RequestMapping("/vendor/dashboard")
    public String vendorDashboard(ModelMap model, HttpSession session, Principal princ) {
        User usr = (User) userService.getByEmail(princ.getName());
        session.setAttribute("user", usr);

        Vendor vendor = vendorService.getVendor(usr.getId());
        session.setAttribute("userType", "vendor");

        if (vendor.getStatus().equalsIgnoreCase("PENDING")) {
            session.removeAttribute("user");
            return "redirect:/login?error=pending";
        } else {
            model.addAttribute("products", vendor.getProducts());
            return "/vendor/dashboard";
        }
    }


    @RequestMapping(value = "/vendor")
    public String vendorHome() {
        return "/vendor/dashboard";
    }

    @RequestMapping(value = "/vendor/welcome")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome!, Inside Vendor welcome");
        return "/vendor/welcome";
    }

    @RequestMapping("/vendor/form")
    public String vendorAdd(Vendor vendor) {
        return "/vendor/form";
    }

    @RequestMapping(value = "/vendor/save", method = RequestMethod.POST)

    public String saveUser(@Valid Vendor vendor, BindingResult result) {
        if (result.hasErrors()) {
            return "vendor/form";
        } else {

            if (vendor.getPassword().equals(vendor.getRepassword())) {

                String password = vendor.getPassword();

                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(password);
                vendor.setPassword(hashedPassword);
                vendor.setRegisterDate(new Date());
                vendor.setStatus("PENDING");
                vendor.setUserRoles(UserRoleService.getVendor());
                vendorService.saveVendor(vendor);
                MailService sendEmail = new MailService();
                sendEmail.sendVendorSignUpEmail(vendor.getEmail(), vendor.getVendorName());
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/vendor/list")
    public String listUsers(Model model) {
        model.addAttribute("vendors", vendorService.listVendors());
        return "vendor/list";
    }

    @RequestMapping("/vendor/edit/{vendorid}")
    public String editUser(@PathVariable("vendorid") Long id, Model model) {
        model.addAttribute("vendor", vendorService.getVendor(id));
        return "vendor/form";
    }

    @RequestMapping("/vendor/save/{vendorid}")
    public String varify(@Valid Vendor vendor, BindingResult result) {
        vendor.setStatus("APPROVED");
        vendorService.saveVendor(vendor);
        return "redirect:/vendor/list";
    }

    @RequestMapping("/vendor/vendorVarification/{vendorid}")
    public String varifyvander(@PathVariable("vendorid") Long id, Model model) {
        model.addAttribute("vendor", vendorService.getVendor(id));
        return "vendor/vendorVarification";
    }

    @RequestMapping("/vendor/delete/{vendorid}")
    public String deleteUser(@PathVariable("vendorid") Long id, Model model) {
        vendorService.deleteVendor(id);
        return "redirect:/vendor/list";
    }

    // Product Add form
    @RequestMapping("vendor/productaddfrm")
    public String productAddForm(Product product, Model model) {
        model.addAttribute("enum_size", Sizes.values());
        model.addAttribute("enum_color", Color.values());
        model.addAttribute("categories", categoryService.listCategory());
        return "vendor/productAddForm";
    }

    @RequestMapping(value = "/vendor/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid Product product, BindingResult result, Model model, HttpSession session, @RequestParam("file") MultipartFile file) {
        if (result.hasErrors()) {
            model.addAttribute("errType", "alert error");
            model.addAttribute("msg", result.toString());
            //return "vendor/dashboard";
        } else {
            try {
                product.setImage(file.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            System.out.println(dateFormat.format(date)); //2014/08/06
            
            Vendor vendor = (Vendor) session.getAttribute("user");
            product.setAddDate(date);
            product.setVendor(vendor);
            vendor.addProduct(product);
            //vendorService.saveVendor(vendor);
            productService.saveProduct(product);
            model.addAttribute("errType", "alert success");
            model.addAttribute("msg", " Successfully Added. ");
        }
        return "redirect:/vendor/dashboard";
    }

    @RequestMapping(value = "/vendor/editProduct", method = RequestMethod.POST)
    public String editProduct(@Valid Product product, BindingResult result, Model model, HttpSession session, @RequestParam("file") MultipartFile file) {
        if (result.hasErrors()) {
            model.addAttribute("errType", "alert error");
            model.addAttribute("msg", result.toString());
            //return "vendor/dashboard";
        } else {
            try {
                product.setImage(file.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Vendor vendor = (Vendor) session.getAttribute("user");
            //product.setVendor(vendor);
            //vendor.addProduct(product);
            //vendorService.saveVendor(vendor);
            productService.saveProduct(product);
            model.addAttribute("errType", "alert success");
            model.addAttribute("msg", " Successfully Updated. ");
        }
        return "redirect:/vendor/dashboard";
    }

    @RequestMapping(value = "/productImage/{id}", method = RequestMethod.GET)
    public void getProductImage(Model model, @PathVariable Long id, HttpServletResponse response) {
        try {
            Product p = productService.getProduct(id);
            if (p != null) {
                OutputStream out = response.getOutputStream();
                out.write(p.getImage());

                response.flushBuffer();
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }
}
