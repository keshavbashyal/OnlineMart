/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.Customer;
import java.util.List;

/**
 *
 * @author Keshav
 */
public interface CustomerService {

    public void saveCustomer(Customer customer);
    public List<Customer> listCustomer();
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);
    
}
