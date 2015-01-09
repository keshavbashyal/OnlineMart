/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.UserDAO;
import com.onlinemart.model.User;
import com.onlinemart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author acer
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDAO userDAO;

    @Override
      public User getByEmail(String email) {
       return userDAO.getUserByEmail(email);
    }
   
       @Override
       @Transactional
    public void addUser(User u){
        userDAO.addUser(u);
    }

}
