/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.UserDAO;
import com.onlinemart.model.User;
import javax.persistence.TypedQuery;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */

@Repository
public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

    @Override
    public User getUserByEmail(String email) {
        String querystr="from User Where email=:email";
        
        Query query= getSession().createQuery(querystr);
        query.setParameter("email", email);
        return (User)query.list().get(0);
       
    }
    @Override
       public void addUser(User u){
         getSession().merge(u);
       }
 
}
