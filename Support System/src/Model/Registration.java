/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author User
 */
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Student> student;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Offered> offers;

    public Registration() {
    }

    public Registration(Long id, Set<Student> student, Set<Offered> offers) {
        this.id = id;
        this.student = student;
        this.offers = offers;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public Set<Offered> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offered> offers) {
        this.offers = offers;
    }

  

    @Override
    public String toString() {
        return offers +"";
    }
    public void addOffered(Offered offer){
       this.offers.addAll(offers);
   }
   

   
    
    
}
