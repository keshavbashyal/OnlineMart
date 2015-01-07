/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.ProductShoppingCartDAO;
import com.onlinemart.dao.SalesDAO;
import com.onlinemart.model.ProductShoppingCart;
import com.onlinemart.model.Sales;
import com.onlinemart.model.Transaction;
import com.onlinemart.service.SalesService;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author acer
 */
@Service
@Transactional
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesDAO salesDAO;
    
    @Autowired
    ProductShoppingCartDAO productShoppingCartDAO;
    
   //@Autowired
    //ProductShopping

    @Override
    public void saveSales(Sales sales) {
        salesDAO.saveSales(sales);
    }

    @Override
    public List<Sales> listSales() {
        return salesDAO.listSales();
    }

    @Override
    public Sales getSales(Long id) {
        return salesDAO.getSales(id);
    }

    @Override
    public void deleteSales(Long id) {
        salesDAO.deleteSales(id);
    }

    @Override
    public List<Sales> findSalesByOrderID(Long id) {
        return salesDAO.findSalesByOrderID(id);
    }

    @Override
    public void addSalesFromTransaction(Transaction txn) {
       Sales  sales;
        Long orderID=txn.getOrder().getId();
        Long txnID=txn.getId();
        Date ordedate=txn.getOrder().getOrderDate();
        
        
        
        List<ProductShoppingCart> productShoppingCartList=txn.getShoppingCart().getProductShoppingCart();
        
       for(ProductShoppingCart ps:productShoppingCartList){
         sales=new Sales();
         sales.setTxnID(txnID);
         sales.setOrderID(orderID);
         sales.setOrderDate(ordedate);
         sales.setProductID(ps.getProduct().getId());
         sales.setQuantity(Integer.parseInt(ps.getQuantity().toString()));
         sales.setProductName(ps.getProduct().getProductName());
         sales.setVendorID(ps.getProduct().getVendor().getId());
         sales.setVendorName(ps.getProduct().getVendor().getVendorName());
         
        salesDAO.saveSales(sales);
           
       }
    }  
       @Override
      public ResultSet getSalesByVendor(Long vendorID, Date from, Date to){
         return salesDAO.getSalesByVendor(vendorID, from, to);
      }
      
      @Override
    public ResultSet getSalesByProduct(Long productID, Date from, Date to){
       return salesDAO.getSalesByProduct(productID, from, to);
    }  
    

    
    
    
    
}
