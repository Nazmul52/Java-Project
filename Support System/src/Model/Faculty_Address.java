/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class Faculty_Address {
    private String email;
    private String phoneNumber;
    private String occuption;
    private String citizenship;
    private String sex;
    private String qualification;

    public Faculty_Address() {
    }

    public Faculty_Address(String email, String phoneNumber, String occuption, String citizenship, String sex, String qualification) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.occuption = occuption;
        this.citizenship = citizenship;
        this.sex = sex;
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOccuption() {
        return occuption;
    }

    public void setOccuption(String occuption) {
        this.occuption = occuption;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Faculty_Address{" + "email=" + email + ", phoneNumber=" + phoneNumber + ", occuption=" + occuption + ", citizenship=" + citizenship + ", sex=" + sex + ", qualification=" + qualification + '}';
    }

  
    
}
