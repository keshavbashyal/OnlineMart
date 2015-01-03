/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.VendorDAO;
import com.onlinemart.model.Vendor;
import com.onlinemart.service.VendorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    @Autowired
    VendorDAO vendorDao;

    @Transactional
    public void saveVendor(Vendor vendor) {
        vendorDao.saveVendor(vendor);
    }

    @Transactional(readOnly = true)
    public List<Vendor> listVendors() {
        return vendorDao.listVendors();
    }

    @Transactional(readOnly = true)
    public Vendor getVendor(Long id) {
        return vendorDao.getVendor(id);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorDao.deleteVendor(id);

    }

    

}
