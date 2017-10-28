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
public enum RoomNo {
    _701,
    _702,
    _703,
    _704,
    _705,
    _706,
    _802,
    _804,
    _901,
    _1001,
    _1002,
    _1004,
    _1005,
    _1201,
    _1202,
    _1203,
    _1204,
    _1101,
    _1102,
    _1103,
    _1104;
    
    @Override
    public String toString() {
        return this.name().replaceAll("_", "");
    }
}
