/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.dao.CreditCardDAO;
import com.onlinemart.model.CreditCard;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author s_paw_000
 */
@Repository
public class CreditCardDAOImpl extends AbstractDAO<CreditCard> implements CreditCardDAO{

    public CreditCardDAOImpl() {
        super();
    }

    @Override
    public void saveCreditCard(CreditCard creditcard) {
       
        getSession().merge(creditcard);
    }

    
    @Override
    public CreditCard getCreditCard(Long id) {
        return super.find(id);
    }

    @Override
    public void deleteCreditCard(Long id) {
        CreditCard c = super.find(id);
        if (c!=null){
            super.remove(c);
        }
    }

    @Override
    public List<CreditCard> getAll() {
        return super.findAll();
    }

    @Override
    public void updateCreditCard(CreditCard creditcard) {
        super.edit(creditcard);
    }
    
}
