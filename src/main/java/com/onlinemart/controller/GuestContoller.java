/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.dao.impl.GuestDAOImpl;
import com.onlinemart.model.Guest;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Keshav
 */
@Controller
public class GuestContoller {

    @Autowired
    private GuestDAOImpl guestDAOImpl;

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

    public void save() {
        guestDAOImpl.saveGuest(new Guest());
    }

    @RequestMapping("/somepage")
    public String someAction(@ModelAttribute("guest") Guest guest, Map<String, Object> map,
            HttpServletRequest request) {

        System.out.println("Name=" + guest.getName() + " description=" + request.getParameter("description"));

        /* do some process and send back the data */
        map.put("somedata", guest);
        map.put("description", request.getParameter("description"));

        return "someotherpage";
    }
}
