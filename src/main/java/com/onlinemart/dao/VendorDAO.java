/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.Vendor;
import java.util.List;

/**
 *
 * @author Keshav
 */
public interface VendorDAO {

    public void saveVendor(Vendor vendor); // create and update
    public List<Vendor> listVendors();
    public Vendor getVendor(Long id);
    public void deleteVendor(Long id);

    public Vendor getVendorById(Long id);

    public List<Vendor> getAllVendors();

}
