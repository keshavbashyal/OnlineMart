/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import com.onlinemart.service.SalesService;
import java.sql.ResultSet;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author acer
 */

public class ReportResult {

    @Autowired
    SalesService salesService;
    
    public ResultSet getVenorReportResult(Date from, Date to) {
        return null;
    }
    
    public ResultSet getAdminReportResult(Date from, Date to) {
        return null;
    }
}
