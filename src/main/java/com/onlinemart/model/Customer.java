/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
    private List<Orders> order;
    
    @OneToMany (cascade = CascadeType.ALL)
    private List<CreditCard> creditCard;
    
    @OneToOne (cascade=CascadeType.ALL)
    private Address address;

    public List<Orders> getOrders() {
        return order;
    }

    public void setOrders(List<Orders> order) {
        this.order = order;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public void addOrders(Orders order){
        this.order.add(order);
    }
    
    
}
