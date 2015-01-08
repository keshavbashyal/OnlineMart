/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.UserRoleDAO;
import com.onlinemart.model.UserRole;
import com.onlinemart.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author acer
 */

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleDAO userRoleDAO;
    
    @Override
    public UserRole getAdminRole() {
        return userRoleDAO.getUserRole("Admin");
    }

    @Override
    public UserRole getVendorRole() {
        return userRoleDAO.getUserRole("Vendor");
    }

    @Override
    public UserRole getCustomerRole() {
        return userRoleDAO.getUserRole("Customer");
    }

}
