/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.model.User;
import com.onlinemart.service.SalesService;
import java.security.Principal;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.crystaldecisions.reports.sdk.*;
import com.crystaldecisions.sdk.occa.report.lib.*;
import com.crystaldecisions.sdk.occa.report.exportoptions.*;
import java.io.*;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author acer
 */
public class ReportController {

    @Autowired
    SalesService salesService;
    @Autowired
    JDBCConnectionController connection;
    
    @Autowired
    ReportStreamWriter reportStreamWriter;
    
    @RequestMapping("/vendor/report/{fronm}/{to}")
    @ResponseBody
    public ModelAndView printVendorResult(@PathVariable("from") Date from, @PathVariable("to") Date to, HttpSession session, Principal princ) {
        
        try{
           String email= ((User)session.getAttribute("user")).getEmail();
           Long vendorID=((User)session.getAttribute("user")).getId();
           
        }
        catch(NullPointerException e){
            return null;
        }
        
        return null;
    }

}
