/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service;

import com.onlinemart.commons.Type;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author s_paw_000
 */
@Service
public interface CreditCardService {
    public void saveCreditCard(com.onlinemart.model.CreditCard creditcard);
    public com.onlinemart.model.CreditCard getCreditCard(Long id);
    public void deleteCreditCard(Long id);
    public List<com.onlinemart.model.CreditCard> getAll(); 
    public void updateCreditCard(com.onlinemart.model.CreditCard creditcard);
    public Type[] getTypes();
}
