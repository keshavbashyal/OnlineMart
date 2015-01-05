/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.Address;
import com.onlinemart.model.Customer;
import java.util.List;

/**
 *
 * @author Keshav
 */
public interface CustomerDAO {
    public void saveCustomer(Customer customer);
    public List<Customer> listCustomer();
    public Customer getCustomer(Long id);
    public void deleteCustomer(Long id);
    //public void addAddress(Address address,Long id);
}
