/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.AddressDAO;
import com.onlinemart.model.Address;
import com.onlinemart.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author psubedi
 */
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressDAO addressDAO;
    
    @Override
    @Transactional
    public void saveAddress(Address address) {
        addressDAO.saveAddress(address);
    }

    @Override
    @Transactional(readOnly = true)
    public Address getAddress(Long id) {
        return addressDAO.getAddress(id);
    }

    @Override
    @Transactional
    public void deleteAddress(Long id) {
        addressDAO.deleteAddress(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> getAll() {
        return addressDAO.getAll();
    }

    @Override
    @Transactional
    public void updateAddress(Address address) {
        addressDAO.updateAddress(address);
    }
    
}

