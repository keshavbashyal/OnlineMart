/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.CustomerDAO;
import com.onlinemart.model.Customer;
import com.onlinemart.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
public class CustomerServiceImpl  implements CustomerService{

   @Autowired
    private CustomerDAO customerDao;

    @Transactional
    public void saveCustomer(Customer customer)
    {
        customerDao.saveCustomer(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> listCustomer()
    {
        return customerDao.listCustomer();
    }

    @Transactional(readOnly = true)
    public Customer getCustomer(int id)
    {
        return customerDao.getCustomer(id);
    }

    @Transactional
    public void deleteCustomer(int id)
    {
        customerDao.deleteCustomer(id);
    }
}
