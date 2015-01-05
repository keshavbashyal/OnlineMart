/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.Address;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author psubedi
 */
@Service
public interface AddressService {

    public void saveAddress(Address address);

    public Address getAddress(Long id);

    public void deleteAddress(Long id);

    public List<Address> getAll();

    public void updateAddress(Address address);
}
