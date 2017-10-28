/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.Religion;
import Enum.Sex;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author User
 */
@Embeddable
public class Personal_Info {
    private String phoneNumber;
    private String email;
    private String dateOfBirth;
    private String occuption;
    private String citizenship;
    private String fatherName;
    private String motherName;
    private String homedistrict;
    private String familyNumber;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    private Religion religion;

    public Personal_Info() {
    }

    public Personal_Info(String phoneNumber, String email, String dateOfBirth, String occuption, String citizenship, String fatherName, String motherName, String homedistrict, String familyNumber, Sex sex, Religion religion) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.occuption = occuption;
        this.citizenship = citizenship;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.homedistrict = homedistrict;
        this.familyNumber = familyNumber;
        this.sex = sex;
        this.religion = religion;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getHomedistrict() {
        return homedistrict;
    }

    public void setHomedistrict(String homedistrict) {
        this.homedistrict = homedistrict;
    }

    public String getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(String familyNumber) {
        this.familyNumber = familyNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    @Override
    public String toString() {
        return "Personal_Info{" + "phoneNumber=" + phoneNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", occuption=" + occuption + ", citizenship=" + citizenship + ", fatherName=" + fatherName + ", motherName=" + motherName + ", homedistrict=" + homedistrict + ", familyNumber=" + familyNumber + ", sex=" + sex + ", religion=" + religion + '}';
    }

   
   
  
}
