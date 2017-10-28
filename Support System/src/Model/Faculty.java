/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author User
 */
@Entity
public class Faculty {
    @Id
    private String facultyInit;
    private String facultyName;
    @Embedded
    private Faculty_Address faculty_address;

    public Faculty() {
    }

    public Faculty(String facultyInit, String facultyName, Faculty_Address faculty_address) {
        this.facultyInit = facultyInit;
        this.facultyName = facultyName;
        this.faculty_address = faculty_address;
    }

    public String getFacultyInit() {
        return facultyInit;
    }

    public void setFacultyInit(String facultyInit) {
        this.facultyInit = facultyInit;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Faculty_Address getFaculty_address() {
        return faculty_address;
    }

    public void setFaculty_address(Faculty_Address faculty_address) {
        this.faculty_address = faculty_address;
    }

    @Override
    public String toString() {
        return  facultyInit ;
    }
    
    
}
