/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.FinancialRecordDAO;
import com.onlinemart.model.FinancialRecord;
import com.onlinemart.model.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Keshav
 */
@Repository
public class FinancialRecordDAOImpl extends AbstractDAO<FinancialRecord> implements FinancialRecordDAO{

    @Override
    public void saveFinancialRecord(FinancialRecord financialRecord) {
        getSession().merge(financialRecord);
    }
    
}
