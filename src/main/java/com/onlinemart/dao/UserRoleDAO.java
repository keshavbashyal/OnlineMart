/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.UserRole;

/**
 *
 * @author s_paw_000
 */
public interface UserRoleDAO {
    public UserRole getUserRole(String role);
    public UserRole find(Long id);
}
