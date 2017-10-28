/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Enum.Day;
import Enum.RoomNo;
import Enum.Section;
import Enum.Time;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author User
 */
@Entity
public class Offered implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Faculty> facultys;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courses;

    @Enumerated(EnumType.STRING)
    private Time time;
   
    @Enumerated(EnumType.STRING)
    private Day day;
    
    @Enumerated(EnumType.STRING)
    private Section sections;
    
    @Enumerated(EnumType.STRING)
    private RoomNo roomNo;

    public Offered() {
    }

    public Offered(Long id, Set<Faculty> facultys, Set<Course> courses, Time time, Day day, Section sections, RoomNo roomNo) {
        this.id = id;
        this.facultys = facultys;
        this.courses = courses;
        this.time = time;
        this.day = day;
        this.sections = sections;
        this.roomNo = roomNo;
    }

  
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Faculty> getFacultys() {
        return facultys;
    }

    public void setFacultys(Set<Faculty> facultys) {
        this.facultys = facultys;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }



    public Section getSections() {
        return sections;
    }

    public void setSections(Section sections) {
        this.sections = sections;
    }

    public RoomNo getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(RoomNo roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return  facultys + " - " + courses + " - " + time +  " - " + day + " - " + sections + " - " + roomNo  ;
    }

    

    
}
