package app.user;

import app.util.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import spark.ExceptionHandler;

import java.util.*;

public class UserDao extends HibernateUtility
{
    public List<User> getAllUsers()
    {
        String hql = "FROM app.user.User order by id desc";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<User> results = query.list();

        return results;
    }

    public User save(User user) throws Exception
    {
        try
        {
            getSessionFactory().openSession().save(user);
            return user;
        }
        catch(Exception e)
        {
            throw new Exception();
        }
    }

    public User update(User user)
    {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        java.util.Date dt = new java.util.Date();
        try{
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    public User getUserByEmail(String email)
    {
        Session session = getSessionFactory().openSession();
        String hql = "FROM app.user.User where email = :email";
        return (User) session.createQuery(hql)
                        .setParameter("email", email)
                        .uniqueResult();
    }

    public User getUserById(int id)
    {
        Session session = getSessionFactory().openSession();
        User user =  (User) session.get(User.class, id);

        return user;
    }

}
