/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.FinancialRecordDAO;
import com.onlinemart.model.FinancialRecord;
import com.onlinemart.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
@Service
@Transactional
public class FinancialRecordServiceImpl implements FinancialRecordService {

    @Autowired
    FinancialRecordDAO financialRecordDao;
    
    @Override
    public void saveFinancialRecord(FinancialRecord financialRecord) {
        financialRecordDao.saveFinancialRecord(financialRecord);
    }
    
}
