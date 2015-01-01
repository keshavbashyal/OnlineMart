/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Keshav
 */
@Entity
public class Customer extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToMany
    private Order order;
    
    @OneToMany
    private CreditCard creditCard;
    
    @OneToOne
    private Address address;
}
