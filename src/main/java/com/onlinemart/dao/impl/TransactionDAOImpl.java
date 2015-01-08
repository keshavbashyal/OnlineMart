/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.SalesDAO;
import com.onlinemart.dao.TransactionDAO;
import com.onlinemart.model.Sales;
import com.onlinemart.model.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Keshav
 */
@Repository
public class TransactionDAOImpl extends AbstractDAO<Transaction> implements TransactionDAO  {

    @Override
    public void saveTransaction(Transaction transaction) {
        getSession().merge(transaction);
    }
    
}
