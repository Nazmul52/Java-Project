/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author John
 */
@Entity
public class Course {
    @Id
    private String code;
    private String title;
    private double credits;
   @OneToMany
   @JoinTable(name="Registration",
          joinColumns=@JoinColumn(name="course_code"),
           inverseJoinColumns=@JoinColumn(name="student_id"))
    private Collection<Student> students;
    public Course() {
        students = new ArrayList<>();
    }

   public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    
    
    
    public Course(String code, String title, double credits) {
        this();
        this.code = code;
        this.title = title;
        this.credits = credits;
    }


    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public double getCredits() {
        return credits;
    }

    
    @Override
    public String toString() {
        return code;
    }

    public void addStudent(Student student) {
       this.students.add(student);
    }

}
