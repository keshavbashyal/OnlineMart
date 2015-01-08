/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.Transaction;

/**
 *
 * @author Keshav
 */
public interface TransactionDAO {
    
    public void saveTransaction(Transaction transaction); // create and update
    
}
