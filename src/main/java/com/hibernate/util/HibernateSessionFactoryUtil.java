package com.hibernate.util;

import com.hibernate.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Configuration conf = new Configuration().configure();
                conf.addAnnotatedClass(User.class);
                conf.addAnnotatedClass(Card.class);
                StandardServiceRegistryBuilder ssrb = new
                        StandardServiceRegistryBuilder().applySettings(conf.getProperties());
                sessionFactory = conf.buildSessionFactory(ssrb.build());
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
