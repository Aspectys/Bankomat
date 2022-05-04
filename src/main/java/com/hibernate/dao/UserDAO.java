package com.hibernate.dao;

import com.hibernate.models.*;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;

import com.hibernate.util.HibernateUtil;



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
        System.out.println("usersDAO: Saved!");
    }
    public void update(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
        System.out.println("usersDAO: Updated!");
    }
    public void delete(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
        System.out.println("usersDAO: deleted!");
    }
    public Card findCardById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Card.class, id);
    }

    public List<User> findAll(){
        List<User> users = (List<User>)
                HibernateUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
