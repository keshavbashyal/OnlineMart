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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
public class VendorServiceImpl implements VendorService{
   
	@Autowired
	private VendorDAO vendorDao;

	@Transactional
	public void saveVendor(Vendor campaign) {
		vendorDao.saveVendor(campaign);
	}

	@Transactional(readOnly = true)
	public List<Vendor> listVendors() {
		return vendorDao.listVendors();
	}

	@Transactional(readOnly = true)
	public Vendor getVendor(int id) {
		return vendorDao.getVendor(id);
	}

	@Transactional
	public void deleteVendor(int id) {
		vendorDao.deleteVendor(id);

	}

    
}
