/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.Sales;
import com.onlinemart.model.Transaction;
import java.util.List;

/**
 *
 * @author acer
 */
public interface SalesService {
    
     public void saveSales(Sales sales); // create and update
    public List<Sales> listSales();
    public Sales getSales(Long id);
    public void deleteSales(Long id);
    public List<Sales> findSalesByOrderID(Long id); 
    
    public void addSalesFromTransaction(Transaction txn);
}
