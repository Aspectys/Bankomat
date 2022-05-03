package com.hibernate.dao;

import com.hibernate.models.*;
import com.hibernate.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
<<<<<<< HEAD

import java.util.ArrayList;
=======
import com.hibernate.util.HibernateUtil;
>>>>>>> b2a3d4121d2ab58bc9ef9f69167e0252d380c901
import java.util.List;


public class UserDAO {
    public User findById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(User.class, id);
    }
    public void save(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }
    public void update(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }
    public void delete(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
    public Card findCardById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Card.class, id);
    }
    public List<User> findAll(){
<<<<<<< HEAD
        ArrayList<User> users = new ArrayList();

        try{
            users = (ArrayList<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
            System.out.println(users);
        }catch (Exception ex){
            ex.printStackTrace();
        }
=======
        List<User> users = (List<User>)
                HibernateUtil.getSessionFactory().openSession().createQuery("From User").list();
>>>>>>> b2a3d4121d2ab58bc9ef9f69167e0252d380c901
        return users;
    }
}
