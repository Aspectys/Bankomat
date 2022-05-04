package com.hibernate.util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.hibernate.models.*;
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Card.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                /*
                sessionFactory = new Configuration().configure().buildSessionFactory();
                Session session = sessionFactory.openSession();
                Transaction t=session.getTransaction();
                session.beginTransaction();
                session.getTransaction().commit();
                session.beginTransaction();
                session.getTransaction().rollback();
                session.close();
                System.out.println("Util: All done!");*/
            } catch (Exception e) {
                System.err.println("ERROR MACRO");
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}