/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.service.impl;

import com.onlinemart.commons.Type;
import com.onlinemart.dao.CreditCardDAO;
import com.onlinemart.model.CreditCard;
import com.onlinemart.service.CreditCardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author s_paw_000
 */
@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService{
    @Autowired
    private CreditCardDAO creditCardDAO;
    
    @Override
    @Transactional
    public void saveCreditCard(CreditCard creditcard) {
        creditCardDAO.saveCreditCard(creditcard);
    }

    @Override
    @Transactional(readOnly = true)
    public CreditCard getCreditCard(Long id) {
        return creditCardDAO.getCreditCard(id);
    }

    @Override
    @Transactional
    public void deleteCreditCard(Long id) {
        creditCardDAO.deleteCreditCard(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CreditCard> getAll() {
        return creditCardDAO.getAll();
    }

    @Override
    @Transactional
    public void updateCreditCard(CreditCard creditcard) {
        creditCardDAO.updateCreditCard(creditcard);
    }

    @Override
    public Type[] getTypes() {
        return creditCardDAO.getTypes();
    }
    
}
