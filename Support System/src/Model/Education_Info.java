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
public class Education_Info {
    private String sscSubject;
    private double sscGrade;
    private int sscYear;
    private String hscSubject;
    private double hscGrade;
    private int hscYear;

    public Education_Info() {
    }

    public Education_Info(String sscSubject, double sscGrade, int sscYear, String hscSubject, double hscGrade, int hscYear) {
        this.sscSubject = sscSubject;
        this.sscGrade = sscGrade;
        this.sscYear = sscYear;
        this.hscSubject = hscSubject;
        this.hscGrade = hscGrade;
        this.hscYear = hscYear;
    }

    

    public String getSscSubject() {
        return sscSubject;
    }

    public void setSscSubject(String sscSubject) {
        this.sscSubject = sscSubject;
    }

    public double getSscGrade() {
        return sscGrade;
    }

    public void setSscGrade(double sscGrade) {
        this.sscGrade = sscGrade;
    }

    public int getSscYear() {
        return sscYear;
    }

    public void setSscYear(int sscYear) {
        this.sscYear = sscYear;
    }

    public String getHscSubject() {
        return hscSubject;
    }

    public void setHscSubject(String hscSubject) {
        this.hscSubject = hscSubject;
    }

    public double getHscGrade() {
        return hscGrade;
    }

    public void setHscGrade(double hscGrade) {
        this.hscGrade = hscGrade;
    }

    public int getHscYear() {
        return hscYear;
    }

    public void setHscYear(int hscYear) {
        this.hscYear = hscYear;
    }

    @Override
    public String toString() {
        return "Education_Info{" + "sscSubject=" + sscSubject + ", sscGrade=" + sscGrade + ", sscYear=" + sscYear + ", hscSubject=" + hscSubject + ", hscGrade=" + hscGrade + ", hscYear=" + hscYear + '}';
    }

    
    
    
}
