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
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    ReportConfiguration reportConfig;

    @RequestMapping("/vendor/report/{from}/{to}")
    @ResponseBody
    public void printVendorResult(@PathVariable("from") Date from, @PathVariable("to") Date to, HttpSession session, Principal princ, HttpServletResponse response) {

        try {
            String email = ((User) session.getAttribute("user")).getEmail();
            Long vendorID = ((User) session.getAttribute("user")).getId();

            String tableName = "";
            
            ReportClientDocument reportClientDoc = new ReportClientDocument();
            reportClientDoc.open(reportConfig.getInputFile(), 0);
            tableName = reportClientDoc.getDatabaseController().getDatabase().getTables().getTable(0).getName();

            try {
                reportClientDoc.getDatabaseController().setDataSource(reportConfig.getVendorData(from, to, vendorID), tableName, "sales");
            } catch (Exception e) {
                System.out.println("setting data source error for vendor");
                e.printStackTrace();
            }

            ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) reportClientDoc.getPrintOutputController().export(ReportExportFormat.PDF);
            reportClientDoc.close();
            reportStreamWriter.write(byteArrayInputStream, response);

        } catch (ReportSDKException ex) {
            System.out.println("Report writting error 1");

        } catch (Exception ex) {
            System.out.println("Report writting error 2");

        }

    }

}


