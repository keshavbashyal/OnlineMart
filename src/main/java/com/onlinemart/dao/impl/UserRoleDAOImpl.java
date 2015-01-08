/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.UserRoleDAO;
import com.onlinemart.model.UserRole;
import org.hibernate.Query;
import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Repository;

/**
 *
 * @author s_paw_000
 */
@Repository
public class UserRoleDAOImpl extends AbstractDAO<UserRole> implements UserRoleDAO {

    @Override
    public UserRole getRole(String role) {
        role = "ROLE_"+role.toUpperCase();
        String q = "FROM UserRole where role=:role";
        Query query = getSession().createQuery(q);
        query.setParameter("role", role);
        if (query.list().isEmpty()){
            System.out.println("Not Found Saving");
            UserRole temp = new UserRole();
            temp.setRole(role);
            getSession().merge(temp);
        }
        return (UserRole) query.list().get(0);
    }
    
    
}
