/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.commons;

/**
 *
 * @author psubedi
 */
public enum Sizes {
    SMALL ("Small"),
    MEDIUM ("Medium"),
    LARGE ("Large");
    
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private Sizes(String label) {
        this.label = label;
    }
    
}
