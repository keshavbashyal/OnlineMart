/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.UserRoleDAO;
import com.onlinemart.model.UserRole;
import com.onlinemart.service.UserRoleService;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author s_paw_000
 */
@Service
public class UserTypeServiceImpl implements UserRoleService {
    
    @Autowired
    private UserRoleDAO userRoleDAO;
    
    @Override
    @Transactional
    public UserRole getAdmin() {
        return userRoleDAO.getRole("admin"); 
    }

    @Override
    @Transactional
    public UserRole getCustomer() {
        return userRoleDAO.getRole("customer");
    }

    @Override
    @Transactional
    public UserRole getVendor() {
        return userRoleDAO.getRole("vendor");
    }
    
}
