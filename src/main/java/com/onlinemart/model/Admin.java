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
import com.onlinemart.model.User;
import javax.persistence.DiscriminatorValue;
/**
 *
 * @author psubedi
 */
@Entity
@DiscriminatorValue("ROLE_ADMIN")
public class Admin extends User implements Serializable{
    
    private String password1;

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}
