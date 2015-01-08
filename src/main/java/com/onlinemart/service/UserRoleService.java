/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.UserRole;
import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Service;

/**
 *
 * @author s_paw_000
 */
@Service
public interface UserRoleService {
    public UserRole getAdmin();
    public UserRole getCustomer();
    public UserRole getVendor();
}
