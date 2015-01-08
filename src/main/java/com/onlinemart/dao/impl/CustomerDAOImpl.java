/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.CustomerDAO;
import com.onlinemart.model.Address;
import com.onlinemart.model.Customer;
import com.onlinemart.utils.SessionUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Keshav
 */
@Repository
public class CustomerDAOImpl extends AbstractDAO<Customer> implements CustomerDAO{

    public CustomerDAOImpl(Class<Customer> entityClass) {
        super(entityClass);
    }
    
    public CustomerDAOImpl() {
        super();
    }
    
    
            
    public void saveCustomer(Customer customer)
    {
        getSession().merge(customer);
    }

    public List<Customer> listCustomer()
    {
        return getSession().createQuery("from Customer").list();
    }
    
    public Customer getCustomer(Long id)
    {
        return (Customer) getSession().get(Customer.class, id);
    }

    public void deleteCustomer(Long id)
    {
        Customer customer = getCustomer(id);
        if(customer != null)
            getSession().delete(customer);
    }
}
