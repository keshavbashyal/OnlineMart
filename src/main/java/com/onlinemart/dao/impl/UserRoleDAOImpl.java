/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.UserRoleDAO;
import com.onlinemart.model.UserRole;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author s_paw_000
 */
@Repository
public class UserRoleDAOImpl extends AbstractDAO<UserRole> implements UserRoleDAO  {
    
    public UserRoleDAOImpl(Class<UserRole> entityClass){
        super(entityClass);
    }

    public UserRoleDAOImpl() {
        super();
    }
    
    @Override
    public UserRole getUserRole(String role) {
        System.out.println("I'm here ");
        role = "ROLE_"+role.toUpperCase();
        String q = "from UserRole u Where u.role =:role";
        Query query = getSession().createQuery(q);
        query.setParameter("role", role);
        System.out.println("Debug " +query.list().size());
        return (UserRole) query.list().get(0);
//        try{
//            return (UserRole)query.list().get(0);
//        }catch(Exception e){
//            UserRole r = new UserRole();
//            r.setRole("ROLE_"+role);
//            super.create(r);
//            return r;
//        }
    }

    @Override
    public UserRole find(Long id) {
        return super.find(id);
    }
   
}
