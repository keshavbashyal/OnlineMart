/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.Product;
import com.onlinemart.model.Sales;
import java.util.List;

/**
 *
 * @author acer
 */

public interface SalesDAO {
    
    public void saveSales(Sales sales); // create and update
    public List<Sales> listSales();
    public Sales getSales(Long id);
    public void deleteSales(Long id);
    public List<Sales> findSalesByOrderID(Long id); 
}
