/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Embeddable;



/**
 *
 * @author John
 */
@Embeddable
public class Address {
    private String district;
    private String upzila;
    private String village;

    public Address() {
    }

    public Address(String district, String upzila, String village) {
        this.district = district;
        this.upzila = upzila;
        this.village = village;
    }

    public String getDistrict() {
        return district;
    }

    public String getUpzila() {
        return upzila;
    }

    public String getVillage() {
        return village;
    }

    @Override
    public String toString() {
        return "Address{" + "district=" + district + ", upzila=" + upzila + ", village=" + village + '}';
    }
    
    
}
