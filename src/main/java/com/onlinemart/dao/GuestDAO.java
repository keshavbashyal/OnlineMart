/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.model.Guest;
import java.util.List;

/**
 *
 * @author Keshav
 */
public interface GuestDAO {
   	
	public void saveGuest(Guest guest); // create and update
	public List<Guest> listGuests();
	public Guest getGuest(Long id);
	public void deleteGuest(Long id);
    
}
