/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.GuestDAO;
import com.onlinemart.model.Guest;
import com.onlinemart.utils.SessionUtil;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Keshav
 */
@Repository
public class GuestDAOImpl extends SessionUtil implements GuestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveGuest(Guest guest) {
        getSession().merge(guest);

    }

    @SuppressWarnings("unchecked")
    public List<Guest> listGuests() {

        return getSession().createCriteria(Guest.class).list();
    }

    public Guest getGuest(Long id) {
        return (Guest) getSession().get(Guest.class, id);
    }

    public void deleteGuest(Long id) {

        Guest guest = getGuest(id);

        if (null != guest) {
            getSession().delete(guest);
        }

    }

}
