package app.receipt;

import app.service.Service;
import app.util.HibernateUtility;
import com.google.common.collect.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import javax.persistence.Entity;

import java.util.*;

public class ReceiptDao extends HibernateUtility{

    public List<Receipt> getAllReceipts()
    {
        String hql = "FROM app.receipt.Receipt order by id desc";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Receipt> results = query.list();

        return results;
    }

    public void store(Receipt receipt)
    {
        getSessionFactory().openSession().save(receipt);
    }

}
