/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.AddressDAO;
import com.onlinemart.dao.CustomerDAO;
import com.onlinemart.model.Address;
import com.onlinemart.model.Customer;
import com.onlinemart.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
@Service
public class CustomerServiceImpl  implements CustomerService{

    @Autowired
    private CustomerDAO customerDao;
    
    @Autowired
    private AddressDAO addressDAO;
    
    @Transactional
    public void saveCustomer(Customer customer)
    {
        customerDao.saveCustomer(customer);
   
    }
    @Transactional
    public void saveAddress(Address address){
        this.addressDAO.saveAddress(address);
    }
    @Transactional(readOnly = true)
    public List<Customer> listCustomer()
    {
        return customerDao.listCustomer();
    }

    @Transactional(readOnly = true)
    public Customer getCustomer(Long id)
    {
        return customerDao.getCustomer(id);
    }

    @Transactional
    public void deleteCustomer(Long id)
    {
        customerDao.deleteCustomer(id);
    }
}
