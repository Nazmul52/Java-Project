/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Embedded;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author John
 */
@Entity
public class Student {
    @Id
    private String id;
    private String studentName;
    private int yearEnrolled;
    @Embedded
    private Address address;

    @OneToMany
     @JoinTable(name="Registration",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="course_code"))
    private Collection<Course> courses;
    
    public Student() {
        courses = new ArrayList<>();
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }
    
    

    public Student(String id, String studentName, int yearEnrolled, Address address) {
        this();
        this.id = id;
        this.studentName = studentName;
        this.yearEnrolled = yearEnrolled;
        this.address = address;
    }

    
    

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public Address getAddress() {
        return address;
    }



    @Override
    public String toString() {
        return id ;
    }

    
   public void addCourse(Course course) {
        this.courses.add(course);
     
   }

   
   

   
}
