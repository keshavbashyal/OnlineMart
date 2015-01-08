/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.OrderDAO;
import com.onlinemart.model.Orders;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Keshav
 */
@Repository
public class OrderDAOImpl extends AbstractDAO<Orders> implements OrderDAO{

    @Override
    public void saveOrder(Orders order) {
        getSession().merge(order);
    }
    
}
