package app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static HibernateUtility instance = null;

    private static SessionFactory sessionFactory;
    //private static StandardServiceRegistry serviceRegistry;

    protected HibernateUtility(){
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        sessionFactory  = new Configuration().configure().
                buildSessionFactory();
    }

    public static HibernateUtility getInstance(){
        if(instance == null){
            instance  = new HibernateUtility();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }



}