/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.FinancialRecord;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keshav
 */
@Service
public interface FinancialRecordService {
    
    public void saveFinancialRecord(FinancialRecord financialRecord);
    
}
