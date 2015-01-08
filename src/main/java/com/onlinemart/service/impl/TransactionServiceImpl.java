/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.TransactionDAO;
import com.onlinemart.model.Transaction;
import com.onlinemart.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    
    @Autowired
    TransactionDAO transactionDao;
    
    @Transactional
    public void saveTransaction(Transaction transaction) {
        transactionDao.saveTransaction(transaction);
    }
    
}
