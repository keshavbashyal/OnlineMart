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

    public void saveVendor(Vendor vendot); // create and update
    public List<Vendor> listVendors();
    public Vendor getVendor(int id);
    public void deleteVendor(int id);

}
