/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Keshav
 */
@Entity
public class Vendor extends User {
    
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
     
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate; 
    private String email; 
    private String password;
    private String vendorName; 
    
    private String registerDate1;

    public String getRegisterDate1() {
        return registerDate1;
    }

    public void setRegisterDate1(String registerDate1) {
        this.registerDate1 = registerDate1;
    }
    
    
    @OneToMany
    private List<Subscription> subscription;
    
    @OneToMany
    private List<Product> products;
    
    

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

   
}
