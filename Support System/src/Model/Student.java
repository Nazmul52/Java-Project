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
public class Student {
    @Id
    private String studentId;
    private String studentName;
    private String program;

    @Embedded
    private Education_Info education_info;
    @Embedded
    private Personal_Info personal_info;

    public Student() {
    }

    public Student(String studentId, String studentName, String program, Education_Info education_info, Personal_Info personal_info) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.program = program;
        this.education_info = education_info;
        this.personal_info = personal_info;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Education_Info getEducation_info() {
        return education_info;
    }

    public void setEducation_info(Education_Info education_info) {
        this.education_info = education_info;
    }

    public Personal_Info getPersonal_info() {
        return personal_info;
    }

    public void setPersonal_info(Personal_Info personal_info) {
        this.personal_info = personal_info;
    }

    @Override
    public String toString() {
        return  studentName;
    }

    
}
