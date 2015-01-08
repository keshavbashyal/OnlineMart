/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.Orders;

/**
 *
 * @author Keshav
 */
public interface OrderDAO {
    public void saveOrder(Orders order); // save Order
}
