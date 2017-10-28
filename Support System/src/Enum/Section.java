/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author User
 */
public enum Section {
    _1,_2,_3,_4,_5;
    
    
   @Override
    public String toString() {
        return this.name().replaceAll("_", "");
    }
    
}
