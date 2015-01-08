/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.OrderDAO;
import com.onlinemart.model.Orders;
import com.onlinemart.model.Orders;
import com.onlinemart.service.OrderService;
import com.onlinemart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
@Service
@Transactional

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDao;

    @Override
    public void saveOrder(Orders order) {
        orderDao.saveOrder(order);

    }

}
