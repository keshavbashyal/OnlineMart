/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.User;

/**
 *
 * @author acer
 */
public interface UserService {
    
    
     public User getByEmail(String email);
     public void addUser(User u);


}