/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.AddressDAO;
import com.onlinemart.dao.AddressDAO;
import com.onlinemart.model.Address;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author psubedi
 */
@Repository
public class AddressDAOImpl extends AbstractDAO<Address> implements AddressDAO {

        public AddressDAOImpl() {
            super();
        }

        @Override
        public void saveAddress(Address address) {
            super.create(address);
        }

        @Override
        public Address getAddress(Long id) {
            return super.find(id);
        }

        @Override
        public void deleteAddress(Long id) {
            Address c = super.find(id);
            if (c != null) {
                super.remove(c);
            }
        }

        @Override
        public List<Address> getAll() {
            return super.findAll();
        }

        @Override
        public void updateAddress(Address address) {
            super.edit(address);
        }

    }
