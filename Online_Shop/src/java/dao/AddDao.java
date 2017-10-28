/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.SubCat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
/**
 *
 * @author John
 */
public class AddDao {
    public boolean addCatagory(Category cat){
        try{
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(cat);
        session.getTransaction().commit();
        session.close();
        
        return true;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean addSubCatagory(SubCat subcat){
        try{
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(subcat);
        session.getTransaction().commit();
        session.close();
        
        return true;
        }catch(Exception ex){
            return false;
        }
    }
}
