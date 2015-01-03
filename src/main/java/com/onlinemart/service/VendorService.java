/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.Vendor;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keshav
 */
@Service
public interface VendorService {

    public void saveVendor(Vendor vendor);
    public List<Vendor> listVendors();
    public Vendor getVendor(int id);
    public void deleteVendor(int id);

    public List<Vendor> getAllVendors();

    public Vendor getVendorById(int id);

   

}
