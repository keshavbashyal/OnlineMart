/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.service.SalesService;
import com.onlinemart.service.impl.SalesServiceImpl;
import java.sql.ResultSet;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 *
 * @author acer
 */
interface ReportConfiguration {

    public ResultSet getVendorData(Date from, Date to, Long vendorID);

    public ResultSet getAdminData(Date from, Date to, Long vendorID);

    public String getInputFile();

    public String getOutputFile();
}

@Controller
public class ReportConfig {

    private @Value("${report.serverTemplateLocation}")
    String inputFile;
    private @Value("C:\\OnlineMartReport.pdf")
    String outputFile;

  @Autowired
    SalesService salesService;

    public ResultSet getVendorData(Date from, Date to, Long vendorID) {

        return salesService.getSalesByVendor(vendorID, from, to);
        //return null;

    }

    public ResultSet getAdminData(Date from, Date to, Long vendorID) {

        return salesService.getSalesByVendor(vendorID, from, to);
        //return null;

    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

}
