/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.SalesDAO;
import com.onlinemart.model.Sales;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public class SalesDAOImpl extends AbstractDAO<Sales> implements SalesDAO  {
    
    
    public SalesDAOImpl(Class<Sales> entityClass) {
        super(entityClass);
    }

    public SalesDAOImpl() {
    }

    @Override
    public void saveSales(Sales sales) {
    getSession().merge(sales);    
    }

    @Override
    public List<Sales> listSales() {
     return getSession().createCriteria(Sales.class).list();    }

    @Override
    public Sales getSales(Long id) {
        return (Sales)getSession().get(Sales.class,id);
    }

    @Override
    public void deleteSales(Long id) {
        getSession().delete(getSales(id));
    }

    @Override
    public List<Sales> findSalesByOrderID(Long id) {
        Query query=getSession().createQuery("from Sales s where s.orderID=:oid");
        query.setLong("oid", id);
                 
        return query.list();
    }
    
    
    public ResultSet getSalesByVendor(Long vendorID, Date from, Date to){
       // Configuration configuration = new Configuration();
       // Connection connection=configuration.getc
        return null;
    }
    public ResultSet getSalesByProduct(Long productID, Date from, Date to){
       return null; 
    }
   
}
