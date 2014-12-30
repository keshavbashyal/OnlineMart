/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.VendorDAO;
import com.onlinemart.model.Vendor;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.onlinemart.utils.SessionUtil;

/**
 *
 * @author Keshav
 */
@Repository
public class VendorDAOImpl extends SessionUtil implements VendorDAO {

    @Override
    public void saveVendor(Vendor vendor) {
        getSession().merge(vendor);
    }

    @Override
    public List<Vendor> listVendors() {
        return getSession().createCriteria(Vendor.class).list();
    }

    @Override
    public Vendor getVendor(int id) {
        return (Vendor) getSession().get(Vendor.class, id);
    }

    @Override
    public void deleteVendor(int id) {
        Vendor vendor = getVendor(id);

        if (vendor != null) {
            getSession().delete(vendor);
        }
    }

}
