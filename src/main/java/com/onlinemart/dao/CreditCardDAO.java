/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao;

import com.onlinemart.commons.Type;
import com.onlinemart.model.CreditCard;
import java.util.List;

/**
 *
 * @author s_paw_000
 */
public interface CreditCardDAO {
    public void saveCreditCard(CreditCard creditcard);
    public CreditCard getCreditCard(Long id);
    public void deleteCreditCard(Long id);
    public List<CreditCard> getAll(); 
    public void updateCreditCard(CreditCard creditcard);
    public Type[] getTypes();
}
