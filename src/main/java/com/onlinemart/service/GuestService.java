/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.model.Guest;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keshav
 */
@Service
public interface GuestService {

    public void saveGuest(Guest guest);
    public List<Guest> listGuests();
    public Guest getGuest(Long id);
    public void deleteGuest(Long id);

}
