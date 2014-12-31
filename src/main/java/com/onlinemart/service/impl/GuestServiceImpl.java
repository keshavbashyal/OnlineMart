/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.dao.GuestDAO;
import com.onlinemart.model.Guest;
import com.onlinemart.service.GuestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Keshav
 */
public class GuestServiceImpl implements GuestService {
    
    @Autowired
    private GuestDAO guestDao;

    
    @Transactional
    public void saveGuest(Guest guest) {
        guestDao.saveGuest(guest);
    }

    @Transactional(readOnly = true)
    public List<Guest> listGuests() {
        return guestDao.listGuests();
    }

   @Transactional(readOnly = true)
    public Guest getGuest(Long id) {
        return guestDao.getGuest(id);
    }

    @Transactional
    public void deleteGuest(Long id) {
        guestDao.deleteGuest(id);
    }
    
}
