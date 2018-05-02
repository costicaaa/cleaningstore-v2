package app.service;

import app.util.HibernateUtility;
import com.google.common.collect.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import javax.persistence.Entity;

import java.util.*;

public class ServiceDao extends HibernateUtility{


//    private final List<Service> services = ImmutableList.of(
//            new Service(1, "Camasa", 999)
//    );
//
    public List<Service> getAllServices() {
        String hql = "FROM app.service.Service";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
//        System.out.println(query.getQueryString());
        List<Service> results = query.list();
//        List<Service> results = new ArrayList<Service>();
//        results = query.list();
//        System.out.println(results);
//        for(Service a : results)
//        {
//            System.out.println(a.getName());
//        }
        return results;
//        return services;
    }

    public Service getServiceById(int id)
    {
        Session session = getSessionFactory().openSession();
        Service service =  (Service) session.get(Service.class, id);
        return service;

    }
//
//    public Book getBookByIsbn(String isbn) {
//        return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
//    }
//
//    public Book getRandomBook() {
//        return books.get(new Random().nextInt(books.size()));
//    }
}
