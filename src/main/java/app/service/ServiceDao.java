package app.service;

import app.util.HibernateUtility;
import com.google.common.collect.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import javax.persistence.Entity;

import java.util.*;

public class ServiceDao extends HibernateUtility{


    public List<Service> getAllServices() {
        String hql = "FROM app.service.Service";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Service> results = query.list();
        return results;
    }

    public Service getServiceById(int id)
    {
        Session session = getSessionFactory().openSession();
        Service service =  (Service) session.get(Service.class, id);
        return service;

    }

}
