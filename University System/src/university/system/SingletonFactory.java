/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.system;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author John
 */
public class SingletonFactory {
    private static final SingletonFactory instance = new SingletonFactory();
    
    private static SessionFactory factory;
    
    private SingletonFactory() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    
    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
