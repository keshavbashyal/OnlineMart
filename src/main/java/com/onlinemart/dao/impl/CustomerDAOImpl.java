/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.CustomerDAO;
import com.onlinemart.model.Customer;
import com.onlinemart.utils.SessionUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
@Repository
public class CustomerDAOImpl extends SessionUtil implements CustomerDAO{
    
    public void saveCustomer(Customer customer)
    {
        getSession().merge(customer);
    }

    public List<Customer> listCustomer()
    {
        return getSession().createCriteria(Customer.class).list();
    }

    public Customer getCustomer(int id)
    {
        return (Customer) getSession().get(Customer.class, id);
    }

    public void deleteCustomer(int id)
    {
        Customer customer = getCustomer(id);
        if(customer != null)
            getSession().delete(customer);
    }
}
