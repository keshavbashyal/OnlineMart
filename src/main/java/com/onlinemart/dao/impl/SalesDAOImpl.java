/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.controller.JDBCConnectionController;
import com.onlinemart.dao.SalesDAO;
import com.onlinemart.model.Sales;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public class SalesDAOImpl extends AbstractDAO<Sales> implements SalesDAO {

    @Autowired
    JDBCConnectionController connection;

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
        return getSession().createCriteria(Sales.class).list();
    }

    @Override
    public Sales getSales(Long id) {
        return (Sales) getSession().get(Sales.class, id);
    }

    @Override
    public void deleteSales(Long id) {
        getSession().delete(getSales(id));
    }

    @Override
    public List<Sales> findSalesByOrderID(Long id) {
        Query query = getSession().createQuery("from Sales s where s.orderID=:oid");
        query.setLong("oid", id);

        return query.list();
    }

    public ResultSet getSalesByVendor(Long vendorID, Date from, Date to) {
        String query = " SELECT `sales`.`txnID`, `sales`.`vendorName`, `sales`.`quantity`, `sales`.`orderID`, `sales`.`productName`, `sales`.`orderDate`\n" +
" FROM   `onlinemart`.`sales` `sales` WHERE `sales`.`vendorID`="+vendorID+ " AND `sales`.`orderDate`>='"+from+"' AND `sales`.`orderDate`<='"+to+"'";
        Connection directConnection = connection.getConnection();

        try {
            Statement statement = directConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //Execute query and return result sets.
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("resultset gettting problem for vendor");
            e.printStackTrace();
        }
        return null;

    }

    public ResultSet getSalesByProduct(Long productID, Date from, Date to) {
         String query = " SELECT `sales`.`txnID`, `sales`.`vendorName`, `sales`.`quantity`, `sales`.`orderID`, `sales`.`productName`, `sales`.`orderDate`\n" +
" FROM   `onlinemart`.`sales` `sales` WHERE `sales`.`productID`="+productID+ " AND `sales`.`orderDate`>='"+from+"' AND `sales`.`orderDate`<='"+to+"'";
        Connection directConnection = connection.getConnection();

        try {
            Statement statement = directConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //Execute query and return result sets.
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("resultset gettting problem for admin");
            e.printStackTrace();
        }
        return null;
    }

}
