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
 * @author John
 */
@Entity
public class Login {
    @Id
    private String userName;
    private String password;
    private String usertype;

    public Login() {
    }

    public Login(String userName, String password, String usertype) {
        this.userName = userName;
        this.password = password;
        this.usertype = usertype;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsertype() {
        return usertype;
    }

    @Override
    public String toString() {
        return "Login{" + "userName=" + userName + ", password=" + password + ", usertype=" + usertype + '}';
    }
    

   
    

   

    
}
