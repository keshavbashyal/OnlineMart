/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.UserRole;

/**
 *
 * @author acer
 */
public interface UserRoleService {
    
    public UserRole getAdminRole();
    public UserRole getVendorRole();
    public UserRole getCustomerRole();
}
