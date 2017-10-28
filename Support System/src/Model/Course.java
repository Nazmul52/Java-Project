/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author User
 */
@Entity
public class Course {
    @Id
    private String courseCode;
    private String courseTitle;
    private int courseCredits;

    public Course() {
    }

    public Course(String courseCode, String courseTitle, int courseCredits) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseCredits = courseCredits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    @Override
    public String toString() {
        return  courseCode + " : " + courseTitle + " :  " + courseCredits + "";
    }

   
    
    
}
